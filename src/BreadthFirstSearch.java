import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Vertex> graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Vertex w : graph.adjacencyList(v)) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }
}