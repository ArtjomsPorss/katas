package com.app.my.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * this variant uses reflection
 * NOT SAFE for external apps because it will create instance of whatever class passed
 */
public class UsingClassName {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Lion l = Factory.get(Lion.class);
        l.roar();

        Dog d = Factory.get(Dog.class);
        d.bark();

    }
}

class Factory {
    public static <T> T get(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int[] ar = new int[]{};
        Constructor<?> c = clazz.getDeclaredConstructor();
        return (T) c.newInstance();
    }
}

class Lion {
    public void roar(){
        System.out.println("roar!");
    }

}

class Dog {
    public void bark() {
        System.out.println("bark!");
    }
}