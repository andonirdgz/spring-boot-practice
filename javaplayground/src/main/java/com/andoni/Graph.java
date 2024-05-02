package com.andoni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Destination {
    private String name;
    private List<Destination> shortestPath = new ArrayList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Destination, Integer> adjacentNodes = new HashMap<>();

    public Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Destination> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Destination> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Destination, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Destination, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addStreet(Destination destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
}

class City {
    private List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination node) {
        destinations.add(node);
    }

    public void dijkstra(Destination source) {
        source.setDistance(0);
        Set<Destination> settledNodes = new HashSet<>();
        Set<Destination> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Destination currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Destination, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Destination adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private Destination getLowestDistanceNode(Set<Destination> unsettledNodes) {
        Destination lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Destination node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinimumDistance(Destination evaluationNode, Integer edgeWeigh, Destination sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Destination> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public void displayPath(Destination destination) {
        if (destination.getDistance() == Integer.MAX_VALUE) {
            System.out.println("No route to destination");
        } else {
            List<Destination> path = destination.getShortestPath();
            for (Destination node : path) {
                System.out.print(node.getName() + " -> ");
            }
            System.out.println(destination.getName() + " : Total Distance = " + destination.getDistance());
        }
    }
}