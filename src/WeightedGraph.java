import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirect;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }
    public WeightedGraph(boolean undirect) {
        this.undirect = undirect;
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }
    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(dest)) {
            addVertex(dest);
        }
        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirect) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).contains(new Edge<>(source, dest));
    }
    public int getVerticesCount() {
        return map.size();
    }
    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }
        if (undirect) {
            count /= 2;
        }
        return count;
    }
    public List<Vertex> adjacencyList(Vertex v) {
        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            vertices.add(e.getDest());
        }
        return vertices;
    }
    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }
}