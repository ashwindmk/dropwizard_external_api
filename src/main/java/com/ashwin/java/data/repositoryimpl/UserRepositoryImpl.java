package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.ExternalApiApplication;
import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class UserRepositoryImpl implements UserRepository {
    private static final Log LOG = LogFactory.getLog(ExternalApiApplication.LOGGER);
    private static final String TAG = UserRepositoryImpl.class.getName();

    private static final String URL = "https://gist.githubusercontent.com/ashwindmk/1e2097ac3de60a40c469ec1a60f35b41/raw/profile.json";

    private ObjectMapper objectMapper;

    @Inject
    public UserRepositoryImpl(ObjectMapper om) {
        objectMapper = om;
    }

    @Override
    public User get() throws Exception {
        User user = null;
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL);
        Invocation.Builder builder = webTarget.request();
        Invocation invocation = builder/*.header("Accept-Encoding", "gzip,deflate")*/.build("GET");
        Response response = invocation.invoke();

        String str = response.readEntity(String.class);
        LOG.debug(TAG + ": External API response { status: " + response.getStatus() + ", body: " + str + " }");

        user = objectMapper.readValue(str, User.class);
        //user = new User("John", "Doe", 25);
        //user = null;
        return user;
    }
}
