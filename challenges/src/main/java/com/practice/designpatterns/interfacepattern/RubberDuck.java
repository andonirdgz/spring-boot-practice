package com.practice.designpatterns.interfacepattern;

public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("I'm a rubber duck");
    }

}
