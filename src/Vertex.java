import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination,weight);
    }

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, adjacentVertices);
    }
}