package com.app.my.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class N2_AddElementsOfArrayToList {
    public static void main(String[] args) {
        Shape[] arr = new Shape[2];
        arr[0] = new Circle();
        arr[1] = new Square();

        List<Shape> lst = new ArrayList<>();

        addAll(arr, lst);

        System.out.println(String.format("list size: [%d]", lst.size()));
        lst.forEach(e -> {
            System.out.println(e.draw());
        });
    }

    public static <T> void addAll(T[] arr , Collection<T> lst) {
        lst.addAll(Arrays.asList(arr));
//        lst.addAll(arr);
    }
}
