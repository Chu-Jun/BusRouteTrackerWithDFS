public class Edge {

    // Declare the variable
    private Vertex source;
    private Vertex destination;
    private double fare;

    // Constructor
    public Edge(Vertex source, Vertex destination, double price) {
        this.source = source;
        this.destination = destination;
        this.fare = price;
    }

    // Get the source station ("vertex") of the edge
    public Vertex getSource() {
        return source;
    }

    // Get the destination station ("vertex") of the edge
    public Vertex getDestination() {
        return destination;
    }

    public double getFare(){
        return fare;
    }
}
