
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        System.out.println("This is V before search" + v);
        System.out.println("This is D before search" + d);
        for (int j = 0; j < numVertices; j++) {
            num[j] = 0;
        }

        
        DFS(v, d);
        
        if (edges.size()!=0) {
            for(int j=0; j<edges.size(); j++){
                System.out.println("!!!" + edges.get(j));
            }
            return edges; // Path from v to d exists
        } else {
            return null; // No path from v to d
        }
    }

    private boolean DFS(Vertex v, Vertex d) {
        num[v.getIndex()] = i++;
        System.out.println(v + " + " +d);
        System.out.println("searching");
        if (v == d) {
            System.out.println("sameeee");
            return true;
        }
        Vertex u;
        // Vertex previous=null;

        // if(count==0){
        //     previous = v;
        //     numOfEdge = v.getAdjacentEdges().size();
        // }
        // if(count == numOfEdge){
        //     v = previous;
        // }
        
        for (Edge e : v.getAdjacentEdges()) {
            u = e.getDestination();
            System.out.println("Check");
            System.out.println(u.getIndex());
            if(num[u.getIndex()] == 0 && v!=d){
                
                System.out.println("Test");
                edges.add(e);
                System.out.println("One edge");
                boolean pathFound = DFS(u,d);
                if(pathFound){
                    System.out.println("Return true");
                    return true;
                }else{
                    edges.remove(edges.size()-1);
                    return false;
                }
            }else{
                System.out.println("Continue");
                continue;
            }
        }
        
        return false;
    }   
}

//  //  Import necessary libraries
//  import java.util.ArrayList;
//  import java.util.List;
 
//  public class DepthFirstSearch {
 
//      private int[] num;
//      public List<Edge> edges;
//      boolean found = false;
//      int i=0;
 
//      public List<Edge> findPathDFS(Vertex v, Vertex d) {
//          int numVertices = StartApplication.graph.countVertices();
//          num = new int[numVertices];
//          edges = new ArrayList<>();
 
//          System.out.println("This is V before search" + v);
//          System.out.println("This is D before search" + d);
//          for (int j = 0; j < numVertices; j++) {
//              num[j] = 0;
//          }
 
//          DFS(v, d);
         
//          if (edges.size()!=0) {
//              for(int j=0; j<edges.size(); j++){
//                  System.out.println("!!!" + edges.get(j));
//              }
//              return edges; // Path from v to d exists
//          } else {
//              return null; // No path from v to d
//          }
//      }
 
//      private boolean DFS(Vertex v, Vertex d) {
//          num[v.getIndex()] = i++;
 
//          if (v == d) {
//              return true;
//          }
//          Vertex u;
//          for (Edge e : v.getAdjacentEdges()) {
//              u = e.getDestination();
//              if(num[u.getIndex()] == 0 && v!=d){
//                  edges.add(e);
//                  boolean pathFound = DFS(u,d);
//                  if(pathFound){
//                      return true;}
//                  }else{
//                      edges.remove(edges.size()-1);
//                  }
//              }
//          return false;
//      }   
//  }

// public class DepthFirstSearch {
//     List<Edge> path;

//     public List<Edge> findPathDFS(Vertex source, Vertex destination) {
//         boolean[] visited = new boolean[StartApplication.graph.countVertices()];
//         path = new ArrayList<>();
//         Stack<Vertex> stack = new Stack<>();
//         Stack<List<Edge>> paths = new Stack<>();

//         stack.push(source);
//         paths.push(new ArrayList<>());
//         visited[source.getIndex()] = true;

//         while (!stack.isEmpty()) {
            
//             Vertex current = stack.pop();
//             List<Edge> currentPath = paths.pop();

//             if (current == destination) {
//                 path = currentPath;
//                 break;
//             }

//             for (Edge edge : current.getAdjacentEdges()) {
//                 Vertex neighbor = edge.getDestination();
//                 System.out.println(path);
//                 if (!visited[neighbor.getIndex()]) {
//                     stack.push(neighbor);
//                     List<Edge> newPath = new ArrayList<>(currentPath);
//                     newPath.add(edge);
                    
//                     paths.push(newPath);
//                     visited[neighbor.getIndex()] = true;
//                 }
//             }
//         }

//         return path;
//     }
// }