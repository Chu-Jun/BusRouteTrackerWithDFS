
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private int[] num;
    public List<Edge> edges = null;
    boolean found = false;
    int i=0;
    int count=0;
    int numOfEdge;

    public List<Edge> findPathDFS(Vertex v, Vertex d) {
        int numVertices = StartApplication.graph.countVertices();
        num = new int[numVertices];
        edges = new ArrayList<>();

        for (int j = 0; j < numVertices; j++) {
            num[j] = 0;
        }

        
        DFS(v, d);
        
        if (edges.size()!=0) {
            return edges; // Path from v to d exists
        } else {
            return null; // No path from v to d
        }
    }

    private boolean DFS(Vertex v, Vertex d) {
        num[v.getIndex()] = i++;
        if (v == d) {
            return true;
        }
        Vertex u;
        for (Edge e : v.getAdjacentEdges()) {
            u = e.getDestination();

            if(num[u.getIndex()] == 0 && v!=d){
                
                edges.add(e);

                boolean pathFound = DFS(u,d);
                if(pathFound){
                    return true;
                }else{
                    edges.remove(edges.size()-1);
                }
            }
        }
        
        return false;
    }   
}