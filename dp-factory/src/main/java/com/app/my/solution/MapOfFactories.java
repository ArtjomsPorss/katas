package com.app.my.solution;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * safer option of Factories - if factory for passed Class is not implemented, it will throw UnsupportedOperationException
 * this forces to pass only programmer-defined classes.
 */
public class MapOfFactories {
    public static void main(String[] args) {
        Cat ca = AnimalFactory.get(Cat.class);
        ca.meow();
        Crow cr = AnimalFactory.get(Crow.class);
        cr.arr();
    }
}

class AnimalFactory {

    public static HashMap<Class<? extends Animal>, IFactory> factories = new HashMap<>();
    static {
        factories.put(Crow.class, new CrowFactory());
        factories.put(Cat.class, new CatFactory());
    }

    public static <T> T get(Type t) {
        if (!factories.containsKey(t)) {
            throw new UnsupportedOperationException(String.format("no factory exists for class:[%s]", t));
        }
        IFactory<T> f = factories.get(t);
        return f.get();
    }
}

class CrowFactory implements IFactory<Crow> {

    @Override
    public Crow get() {
        return new Crow();
    }
}

class CatFactory implements IFactory<Cat> {

    @Override
    public Cat get() {
        return new Cat();
    }
}

interface IFactory<T> {
    T get();
}

class Cat implements Animal {
    public void meow() {
        System.out.println("meow!");
    }
}

class Crow implements Animal {
    public void arr() {
        System.out.println("arr!");
    }
}

interface Animal {}