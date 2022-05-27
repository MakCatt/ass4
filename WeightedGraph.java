package com.company;

import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private Set<Vertex<T>> set = new HashSet<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> vertex) {
        set.add(vertex);
    }


    public void addEdgePrivate(Vertex<T> source, Vertex<T> destination, double weight) {
        set.add(source);
        for (Vertex<T> vertex : set) {
            if (vertex.equals(source)) {
                vertex.addAdjacentVertex(destination, weight);
            }
        }
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        addEdgePrivate(source, destination, weight);
        if (undirected) {
            addEdgePrivate(destination, source, weight);
        }
    }


    public Iterable<Vertex<T>> adjacencyList(Vertex<T> vertex) {
        if (set.contains(vertex)) {
            List<Vertex<T>> vertices = new ArrayList<>();
            for (Vertex<T> v : set)
                if (v.equals(vertex))
                    vertices.addAll(v.getAdjacentVertices().keySet());
            return vertices;
        }
        return null;
    }

    public Set<Vertex<T>> getVertices() {
        return set;
    }
}