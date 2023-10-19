package com.app.my;

public class Singleton {
    private static Singleton instance;
    private Singleton(){};

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // methods and fields that needs to be performed by a Type that must have only one instance
}
