package com.company;

import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    private final T data;
    private final Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<T> destination, double weight) {
            adjacentVertices.put(destination, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    public T getData() {
        return data;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
