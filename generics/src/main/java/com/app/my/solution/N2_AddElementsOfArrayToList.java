package com.app.my.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class N2_AddElementsOfArrayToList {
    public static void main(String[] args) {
        // Shape array containing Shape subclasses to Shape List
        Shape[] arr = new Shape[2];
        arr[0] = new Circle();
        arr[1] = new Square();

        List<Shape> lst = new ArrayList<>();

        addAll(arr, lst);

        System.out.println(String.format("list size: [%d]", lst.size()));
        lst.forEach(e -> {
            System.out.println(e.draw());
        });


        // String array to Object List
        // because compiler infers most speficic type argument that will make the call type-correct
        String[] sarr = new String[100];
        List<Object> lob = new ArrayList<>();
        addAll(sarr, lob);
        System.out.println(String.format("string arr to object collection: [%d]", lob.size()));

        // String array to Object List using Generic extends
        // S extends T = String is subclass of Object
        String[] sarr1 = new String[100];
        List<Object> lob1 = new ArrayList<>();
        addAllST(sarr1, lob1);
        System.out.println(String.format("string arr to object collection using generic extends: [%d]", lob1.size()));
    }

    public static <T> void addAll(T[] arr , Collection<T> lst) {
        lst.addAll(Arrays.asList(arr));
    }
    public static <T, S extends T> void addAllST(S[] arr , Collection<T> lst) {
        lst.addAll(Arrays.asList(arr));
    }
}
