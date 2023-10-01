package com.amil.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldbean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWorldbean{" +
                "name='" + name + '\'' +
                '}';
    }

    public HelloWorldbean(String message) {
        this. name = message;
    }
}
