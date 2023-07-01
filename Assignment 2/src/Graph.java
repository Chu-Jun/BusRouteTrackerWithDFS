
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;

public class Graph {

    // Declare variable
    public static List<Vertex> vertices;

    // Constructor
    public Graph() {
        vertices = new ArrayList<>();
    }

    // addVertex function to add new station ("vertex") to the graph
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    // Return the list of station ("vertices")
    public List<Vertex> getVertices() {
        return vertices;
    }

    // Return the size of the vertices list = number of station available
    public int countVertices() {
        return vertices.size();
    }

    // Remove the selected station ("vertex") according to the index number
    public void removeVertex(int index){

        // Remove all adjacent edges before deleting the vertex
        List<Edge> adjacentEdges = vertices.get(index).getAdjacentEdges();
        while(adjacentEdges.size()!=0){
            vertices.get(index).deleteAdjacentEdge(0);
        }

        // Remove the vertex from the graph
        vertices.remove(index);
    }
    
}