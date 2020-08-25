package com.ashwin.java;

import com.ashwin.java.di.ExternalApiModule;
import com.ashwin.java.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExternalApiApplication extends Application<ExternalApiConfiguration> {
    public static final String LOGGER = "external-api-logger";
    private static final String TAG = ExternalApiApplication.class.getName();

    private static Log LOG = LogFactory.getLog(LOGGER);

    public static void main(String[] args) throws Exception {
        LOG.info(TAG + ": Main (" + args + ")");
        new ExternalApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "external-api";
    }

    @Override
    public void run(ExternalApiConfiguration config, Environment env) throws Exception {
        LOG.info(TAG + ": Run (" + config + ", " + env + ")");
        env.jersey().getResourceConfig().register(new ExternalApiModule(env));
        env.jersey().register(UserResource.class);
    }
}
