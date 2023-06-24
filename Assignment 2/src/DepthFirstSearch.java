import java.util.ArrayList;
import java.util.List;
import java.lang.System;

public class DepthFirstSearch {

    private int[] num;
    public List<Edge> edges;
    private int i;

    public List<Edge> findPathDFS(Vertex v, Vertex d) {
        int numVertices = StartApplication.graph.countVertices();
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
    Vertex u = null;
    if (u != d) {
        for (Edge e : v.getAdjacentEdges()) {
            u = e.getDestination();
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