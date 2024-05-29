import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distTo;
    private final WeightedGraph<Vertex> graph;

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;
        distTo = new HashMap<>();
        unsettledNodes = new HashSet<>();

        for (Vertex v : graph.getAllVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        distTo.put(source, 0.0);
        unsettledNodes.add(source);

        dijkstra();
    }

    private void dijkstra() {
        while (!unsettledNodes.isEmpty()) {
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);
            unsettledNodes.remove(currentNode);
            marked.add(currentNode);

            for (Map.Entry<Vertex, Double> entry : graph.getAdjacentVertices(currentNode).entrySet()) {
                Vertex neighbor = entry.getKey();
                double weight = entry.getValue();
                relax(currentNode, neighbor, weight);
            }
        }
    }

    private void relax(Vertex v, Vertex w, double weight) {
        double distThroughV = distTo.get(v) + weight;
        if (distTo.get(w) > distThroughV) {
            distTo.put(w, distThroughV);
            edgeTo.put(w, v);
            unsettledNodes.add(w);
        }
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        double minDistance = Double.MAX_VALUE;

        for (Vertex vertex : vertices) {
            double vertexDistance = getShortestDistance(vertex);
            if (vertexDistance < minDistance) {
                minDistance = vertexDistance;
                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        return distTo.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    public double getShortestDistanceTo(Vertex vertex) {
        return distTo.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }

    public List<Vertex> getPath(Vertex destination) {
        List<Vertex> path = new ArrayList<>();
        if (!distTo.containsKey(destination)) {
            return path;
        }
        for (Vertex at = destination; at != null; at = edgeTo.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
