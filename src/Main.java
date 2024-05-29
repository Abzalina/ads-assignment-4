import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Aktobe");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Aktobe");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Nur-Sultan");
        graph.addEdge("Shymkent", "Aktau");
        graph.addEdge("Aktau", "Nur-Sultan");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Nur-Sultan");
        graph.addEdge("Nur-Sultan", "Kostanay");
        graph.addEdge("Shymkent", "Aktobe");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Nur-Sultan", 2.1);
        graph.addEdge("Shymkent", "Aktau", 7.8);
        graph.addEdge("Aktau", "Nur-Sultan", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Nur-Sultan", 3.9);
        graph.addEdge("Nur-Sultan", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Aktobe", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
