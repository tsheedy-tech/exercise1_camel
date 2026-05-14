package com.example.exercise1_camel.model;

import lombok.Data;

@Data
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
