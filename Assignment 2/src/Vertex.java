import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int index;
    private List<Edge> adjacentEdges;

    public Vertex(int index) {
        this.index = index;
        adjacentEdges = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public void addAdjacentEdge(Edge edge) {
        adjacentEdges.add(edge);
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }
}
