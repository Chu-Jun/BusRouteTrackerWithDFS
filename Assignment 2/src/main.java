import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        
        // Create vertices
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        // Add vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        
        // Create edges
        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v2, v3);
        Edge e3 = new Edge(v3, v4);
        Edge e4 = new Edge(v4, v5);
        Edge e5 = new Edge(v1, v3);
        Edge e6 = new Edge(v2, v4);

        // Add edges to the vertices
        v1.addAdjacentEdge(e1);
        v2.addAdjacentEdge(e2);
        v3.addAdjacentEdge(e3);
        v4.addAdjacentEdge(e4);
        v1.addAdjacentEdge(e5);
        v2.addAdjacentEdge(e6);

        
        // Perform DFS or any other operations on the graph
        DepthFirstSearch dfs = new DepthFirstSearch();
        List<Edge> shortestPath = dfs.findPathDFS(v1, v3, graph);

        System.out.println("V1: "+ v1);
        System.out.println("V3: "+ v3);
        System.out.println("The shortest path from "+v1+" to "+v3+": ");
        for(int i=0; i<shortestPath.size(); i++){
            System.out.println(shortestPath.get(i));
        }
    }
}
