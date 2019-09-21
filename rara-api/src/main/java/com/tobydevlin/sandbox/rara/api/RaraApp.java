package com.tobydevlin.sandbox.rara.api;

import com.tobydevlin.sandbox.rara.api.configurations.RaraConfiguration;
import com.tobydevlin.sandbox.rara.api.healthchecks.RaraHealthCheck;
import com.tobydevlin.sandbox.rara.api.resources.MetadataResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RaraApp extends Application<RaraConfiguration> {

    public static void main(String[] args) throws Exception {
        new RaraApp().run(args);
    }

    public void run(RaraConfiguration config, Environment environment) {
        // RESOURCES
        final MetadataResource metadataResource = new MetadataResource(config.getMetadata());
        environment.jersey().register(metadataResource);

        // todo: SWAGGER

        //HEALTH CHECKS
        final RaraHealthCheck healthCheck = new RaraHealthCheck(config.getMetadata());
        environment.healthChecks().register("version", healthCheck);
    }

}
