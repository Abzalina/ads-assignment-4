import java.util.*;

public class Search<Vertex> {
    private final Vertex source;
    private Map<Vertex, Vertex> edgeTo;
    private Set<Vertex> marked;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean contains(Vertex v) {
        return marked.contains(v);
    }
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!contains(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex a = v; a != source; a = edgeTo.get(a)) {
            path.add(a);
        }
        path.add(source);
        return path;
    }
}