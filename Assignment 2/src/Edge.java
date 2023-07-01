public class Edge {

    // Declare the variable
    private Vertex source;
    private Vertex destination;

    // Constructor
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    // Get the source station ("vertex") of the edge
    public Vertex getSource() {
        return source;
    }

    // Get the destination station ("vertex") of the edge
    public Vertex getDestination() {
        return destination;
    }
}
