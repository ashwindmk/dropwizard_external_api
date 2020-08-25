package com.ashwin.java.resource;

import com.ashwin.java.ExternalApiApplication;
import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private static final Log LOG = LogFactory.getLog(ExternalApiApplication.LOGGER);
    private static final String TAG = UserResource.class.getName();

    private UserRepository userRepository;

    @Inject
    public UserResource(UserRepository ur) {
        userRepository = ur;
    }

    @GET
    public Response get() {
        Response response = null;
        try {
            User user = userRepository.get();
            if (user != null) {
                response = Response.ok(user).build();
            } else {
                response = Response.noContent().build();
            }
            LOG.info(TAG + ": External API response user: " + user);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(TAG + ": Exception while getting external API response", e);
            response = Response.serverError().build();
        }
        return response;
    }
}
