package com.app.my.solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class N1_DrawDifferentShapes {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        // drawing list of shapes
        drawAll(shapes);
        // drawing list of child class - Circle
        List<Circle> circles = List.of(new Circle(), new Circle());
        drawAll(circles);


        List<Shape> shapeList = new ArrayList<>(List.of(new Circle(), new Square()));
        // ? can be Shape or it's parent, meaning the List can take in Shapes for sure (child class of ?)
        add(shapeList);
    }

    // a method can add to generic Shape collection when it's defined like this
    public static void add(Collection<? super Shape> col) {
        col.add(new Square());
        col.add(new Circle());
    }

    // ? can be Shape or it's child
    public static void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            System.out.println(s.draw());
        }
    }
}

interface Shape {
    String draw();
}

class Circle implements Shape {

    @Override
    public String draw() {
        return "circle";
    }
}


class Square implements Shape {
    @Override
    public String draw() {
        return "square";
    }
}