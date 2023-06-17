import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private int[] num;
    private List<Edge> edges;
    private int i;

    // public List<Edge> findPathDFS(Vertex v, Vertex d, Graph obj) {
    //     int numVertices = obj.countVertices();
    //     num = new int[numVertices];
    //     edges = new ArrayList<>();
    //     i = 0;

    //     for (int j = 0; j < numVertices; j++) {
    //         num[j] = 0;
    //     }

        
    //     while (v != d && hasUnexploredVertex()){
    //         System.out.println("The shortest path from ");         
    //         DFS(v, d);
    //     }

        
    //     if (v == d) {
    //         return edges; // Path from v to d exists
    //     } else {
    //         return null; // No path from v to d
    //     }
    // }

    // private boolean hasUnexploredVertex() {
    //     for (int j = 0; j < num.length; j++) {
    //         if (num[j] == 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private void DFS(Vertex v, Vertex d) {
    //     num[v.getIndex()] = i++;
    
    //     if (v != d) {
    //         for (Edge e : v.getAdjacentEdges()) {
    //             Vertex u = e.getDestination();
    //             int uIndex = u.getIndex();
    //             if (uIndex >= 0 && uIndex < num.length && num[uIndex] == 0) {
    //                 edges.add(e);
    //                 DFS(u, d);
    //             }
    //         }
    //     }
    // }

    public List<Edge> findPathDFS(Vertex v, Vertex d, Graph obj) {
    int numVertices = obj.countVertices();
    num = new int[numVertices];
    edges = new ArrayList<>();
    i = 0;

    System.out.println("This is V before search" + v);
    System.out.println("This is D before search" + d);
    for (int j = 0; j < numVertices; j++) {
        num[j] = 0;
    }

    DFS(v, d);
    
    if (edges.size()!=0) {
        for(int i=0; i<edges.size(); i++){
            System.out.println("!!!" + edges.get(i));
        }
        return edges; // Path from v to d exists
    } else {
        return null; // No path from v to d
    }
}

private void DFS(Vertex v, Vertex d) {
    num[v.getIndex()] = i++;

    if (v != d) {
        for (Edge e : v.getAdjacentEdges()) {
            Vertex u = e.getDestination();
            if (num[u.getIndex()] == 0) {
                edges.add(e);
                DFS(u, d);
                for(int i=0; i<edges.size(); i++){
                    System.out.println(edges.get(i));
                }
                if (u == d) {
                    System.out.println("This is v"+v);
                    System.out.println("This is u"+u);
                    System.out.println("This is d"+d);
                    return; // Exit DFS if destination is reached
                }
            }
        }
    }
}
    
    
}