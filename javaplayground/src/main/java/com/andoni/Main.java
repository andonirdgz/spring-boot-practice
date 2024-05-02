package com.andoni;

public class Main {
    public static void main(String[] args) {
        Destination nodeA = new Destination("A");
        Destination nodeB = new Destination("B");
        Destination nodeC = new Destination("C");
        Destination nodeD = new Destination("D");

        nodeA.addStreet(nodeB, 10);
        nodeA.addStreet(nodeC, 15);

        nodeB.addStreet(nodeD, 12);
        nodeC.addStreet(nodeD, 10);

        City city = new City();
        city.addDestination(nodeA);
        city.addDestination(nodeB);
        city.addDestination(nodeC);
        city.addDestination(nodeD);

        city.dijkstra(nodeA);
        city.displayPath(nodeD);
    }
}
