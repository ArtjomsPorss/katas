package com.app.my.solution;

import java.util.ArrayList;
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

    }

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