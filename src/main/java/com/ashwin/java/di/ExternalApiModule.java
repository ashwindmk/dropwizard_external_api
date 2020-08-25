package com.ashwin.java.di;

import com.ashwin.java.data.repositoryimpl.UserRepositoryImpl;
import com.ashwin.java.domain.repository.UserRepository;
import com.ashwin.java.resource.UserResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class ExternalApiModule extends AbstractBinder {
    private Environment env;

    public ExternalApiModule(Environment env) {
        this.env = env;
    }

    @Override
    protected void configure() {
        bind(this.env.getObjectMapper()).to(ObjectMapper.class);
        bind(UserRepositoryImpl.class).to(UserRepository.class).in(Singleton.class);
        bind(UserResource.class).to(UserResource.class).in(Singleton.class);
    }
}
