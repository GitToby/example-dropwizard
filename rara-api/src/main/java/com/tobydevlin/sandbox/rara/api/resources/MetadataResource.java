package com.tobydevlin.sandbox.rara.api.resources;


import com.tobydevlin.sandbox.rara.api.configurations.pojo.Hello;
import com.tobydevlin.sandbox.rara.api.configurations.pojo.Metadata;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class MetadataResource {
    private final Metadata metadata;
    private final AtomicLong counter;

    public MetadataResource(Metadata metadata) {
        this.metadata = metadata;
        this.counter = new AtomicLong();
    }

    @GET
    @Path("/version")
    public Metadata getVersion() {
        counter.incrementAndGet();
        return metadata;
    }

    @GET
    @Path("/counter")
    public AtomicLong getCount() {
        return this.counter;
    }

    @GET
    @Path("/hello/{name}")
    public Hello sayHello(@PathParam("name") String name) {
        return new Hello(name);
    }
}