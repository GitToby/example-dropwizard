package com.tobydevlin.sandbox.rara.api.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import com.tobydevlin.sandbox.rara.api.configurations.pojo.Metadata;

public class RaraHealthCheck extends HealthCheck {
    private final Metadata metadata;

    public RaraHealthCheck(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    protected Result check() {
        final String saying = String.format(metadata.getVersion(), "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
