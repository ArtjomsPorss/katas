package com.app.my;

public class Person {
    private final Long id;

    public Person(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("person with id: [%d]", this.id);
    }
}
