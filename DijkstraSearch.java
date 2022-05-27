package com.company;

import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private Set<Vertex<T>> unsettledNodes;
    private Map<Vertex<T>, Double> distances;
    private WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Vertex<T> node = getTertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (Vertex<T> target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(Vertex<T> node, Vertex<T> target) {
        if (graph.getVertices().contains(node))
            for (Vertex<T> Vertex : graph.getVertices())
                if (Vertex.equals(node))
                    for (Vertex<T> tempTarget : Vertex.getAdjacentVertices().keySet())
                        if (tempTarget.equals(target))
                            return Vertex.getAdjacentVertices().get(target);
        throw new RuntimeException("Not found!");
    }

    private Vertex<T> getTertexWithMinimumWeight(Set<Vertex<T>> Vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> Vertex : Vertices) {
            if (minimum == null)
                minimum = Vertex;
            else {
                if (getShortestDistance(Vertex) < getShortestDistance(minimum))
                    minimum = Vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex<T> destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}