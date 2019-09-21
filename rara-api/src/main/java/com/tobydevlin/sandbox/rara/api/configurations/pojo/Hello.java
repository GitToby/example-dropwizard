package com.tobydevlin.sandbox.rara.api.configurations.pojo;

public class Hello {
    private String hello;

    public Hello(String name) {
        this.hello = name;
    }

    public void setHello(String name) {
        this.hello = name;
    }

    public String getHello() {
        return hello;
    }
}
