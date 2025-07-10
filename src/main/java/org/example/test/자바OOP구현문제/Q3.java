package org.example.test.자바OOP구현문제;

abstract class Shape {
    abstract double GetArea(double i);

}

class Circle extends Shape{
    static double pi = 3.14;

    @Override
    double GetArea(double radius) {
        return (Math.pow(radius,2)) * pi;
    }

}

class Rectangle extends Shape{
    @Override
    double GetArea(double length) {
        return (Math.pow(length, 2));
    }
}


public class Q3 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        System.out.println(circle.GetArea(2.3));
        System.out.println(rectangle.GetArea(33));
    }
}
