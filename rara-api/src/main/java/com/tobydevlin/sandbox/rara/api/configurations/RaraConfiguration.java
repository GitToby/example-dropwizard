package com.tobydevlin.sandbox.rara.api.configurations;

import com.tobydevlin.sandbox.rara.api.configurations.pojo.Metadata;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class RaraConfiguration extends Configuration {
    @NotNull
    @JsonProperty("metadata")
    private Metadata metadata = new Metadata();

    public Metadata getMetadata() {
        return metadata;
    }

    @NotEmpty
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }
}
