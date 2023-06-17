import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
    public int countVertices() {
        return vertices.size();
    }
    
}