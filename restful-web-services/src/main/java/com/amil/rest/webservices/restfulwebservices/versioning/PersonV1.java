package com.amil.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PersonV1(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
