
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private int[] num;
    public List<Edge> edges;
    boolean found = false;
    int i=0;

    public List<Edge> findPathDFS(Vertex v, Vertex d) {
        int numVertices = StartApplication.graph.countVertices();
        num = new int[numVertices];
        edges = new ArrayList<>();

        System.out.println("This is V before search" + v);
        System.out.println("This is D before search" + d);
        for (int j = 0; j < numVertices; j++) {
            num[j] = 0;
        }
        

        // while(v!=d && hasUnexploredVertex()){
        //     DFS(v, d);
        // }

        DFS(v, d);
        
        // if (v==d) {
        //     for(int j=0; j<edges.size(); j++){
        //         System.out.println("!!!" + edges.get(j));
        //     }
        //     return edges; // Path from v to d exists
        // } else {
        //     return null; // No path from v to d
        // }
        if (edges.size()!=0) {
            for(int j=0; j<edges.size(); j++){
                System.out.println("!!!" + edges.get(j));
            }
            return edges; // Path from v to d exists
        } else {
            return null; // No path from v to d
        }
    }

    // private boolean hasUnexploredVertex() {
    //     for (int j = 0; j < num.length; j++) {
    //         if (num[j] == 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    private boolean DFS(Vertex v, Vertex d) {
        num[v.getIndex()] = i++;
        // if (v != d) {

        //     for (Edge e : v.getAdjacentEdges()) {
        //         Vertex u = e.getDestination();
        //         if (num[u.getIndex()] == 0) {
                        
        //             if(found != true){
        //                 edges.add(e);
        //                 System.out.println("%%%%%%%%%%%%");
        //                 for(int i=0; i<edges.size(); i++){
        //                 System.out.println(edges.get(i));
        //             }
        //                 DFS(u, d);
        //             }
                        
        //             System.out.println("************");
        //             for(int i=0; i<edges.size(); i++){
        //                 System.out.println(edges.get(i));
        //             }
        //                 if (u == d) {
        //                 System.out.println("This is v"+v);
        //                 System.out.println("This is u"+u);
        //                 System.out.println("This is d"+d);
        //                 found = true; // Exit DFS if destination is reached
        //             }
        //         }
        //     }
            
        // }

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
        //return u;
        // return;
        

        // for (int adjacentVertex : adjacencyList[vertex]) {
        //     if (num[adjacentVertex] == 0 && vertex != destination) {
        //         edges.add(adjacentVertex);
        //         boolean pathFound = dfs(adjacentVertex, destination, num, edges, i);
        //         if (pathFound) {
        //             return true;
        //         } else {
        //             edges.removeLast();
        //         }
        //     }
        // }
    }   
}