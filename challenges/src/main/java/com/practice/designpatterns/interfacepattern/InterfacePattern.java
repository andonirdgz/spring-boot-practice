package com.practice.designpatterns.interfacepattern;

public class InterfacePattern {
    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck();

        rubberDuck.performFly();
        rubberDuck.performQuack();

        rubberDuck.swim();

    }
}
