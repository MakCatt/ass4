package com.company;
//unchanged from your github
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        Vertex<String> Almaty = new Vertex<>("Almaty");
        Vertex<String> Astana = new Vertex<>("Astana");
        Vertex<String> Shymkent = new Vertex<>("Shymkent");
        Vertex<String> Kostanay = new Vertex<>("Kostanay");
        Vertex<String> Kyzylorda = new Vertex<>("Kyzylorda");
        graph.addEdge(Almaty, Astana, 2.1);
        graph.addEdge(Almaty, Shymkent, 7.2);
        graph.addEdge(Shymkent, Astana, 3.9);
        graph.addEdge(Astana, Kostanay, 3.5);
        graph.addEdge(Shymkent, Kyzylorda, 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<String>(graph, Almaty);
        outputPath(djk, Kyzylorda);

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<String>(graph, Almaty);
        outputPath(bfs, Kyzylorda);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v.getData() + " -> ");
        }
    }
}