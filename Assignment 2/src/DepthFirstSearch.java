
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;

// Depth first search algorithm to  find available path in the graph
public class DepthFirstSearch {

    // Declare and initialize the variable 
    private int[] num;
    public List<Edge> edges = null;
    boolean found = false;
    int i=0;
    int count=0;
    int numOfEdge;

    //findPathDFS that will call the DFS function to recursively search for path available
    public List<Edge> findPathDFS(Vertex v, Vertex d) {
        // Get the number of vertices in the graph
        int numVertices = StartApplication.graph.countVertices();

        //Initialize the num array using the number of vertices in the graph
        num = new int[numVertices];

        // Initialize the edges list to save the edges involved in the path
        edges = new ArrayList<>();

        // Use for loop to initialize the num for each array element as 0
        for (int j = 0; j < numVertices; j++) {
            num[j] = 0;
        }

        // Call DFS function
        DFS(v, d);
        
        // Check whether there is path available for the source and destination selected
        if (edges.size()!=0) {
            return edges; // Path from v to d exists
        } else {
            return null; // No path from v to d
        }
    }

    // DFS function to recursively check the available path 
    private boolean DFS(Vertex v, Vertex d) {
        // Increment the array element to mark it as visited
        num[v.getIndex()] = i++;

        // If v is equal to d, it means the path is found
        if (v == d) {
            return true;
        }

        // Declare vertex u to temporarily hold the vertex
        Vertex u;

        // Use for loop to check every edge connected to each vertex
        for (Edge e : v.getAdjacentEdges()) {

            // Get the destination vertex of the edge (route)
            u = e.getDestination();

            // If the vertex in not visited yet and the path is still not found
            if(num[u.getIndex()] == 0 && v!=d){
                
                // Add the edge to the edge list
                edges.add(e);

                // Recursively call the DFS function
                boolean pathFound = DFS(u,d);

                // Check whether the path is found, based on the pathFound variable, 
                // if the path is found, return true, if the path is not found remove the last edge as it is not the correct route
                if(pathFound){
                    return true;
                }else{
                    edges.remove(edges.size()-1);
                }
            }
        }
        
        // Return false if the path is not found
        return false;
    }   
}