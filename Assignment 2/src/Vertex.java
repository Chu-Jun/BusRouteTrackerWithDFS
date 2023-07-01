
//  Import necessary libraries
import java.util.ArrayList;
import java.util.List;

public class Vertex {

    // Declare variable
    private int index;
    public ArrayList<String> station = new ArrayList<String>();
    private List<Edge> adjacentEdges;

    // Constructor
    public Vertex(int index, String stationName) {
        this.index = index;
        addStationName(stationName);
        adjacentEdges = new ArrayList<>();
    }

    // Add station name for the vertex selected
    public void addStationName(String name){
        station.add(0, name);
    }

    // Default constructor
    public Vertex() {
    }

    // Return the index for the selected vertex
    public int getIndex() {
        return index;
    }

    // Return the station name for the selected vertex
    public String getStationName(int stationIndex) {
        return station.get(stationIndex);
    }

    // Add new adjacent edge for the selected vertex
    public void addAdjacentEdge(Edge edge) {
        adjacentEdges.add(edge);
    }

    // Return the list of adjacent edges
    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    // Delete the adjacent edges of the selected vertex
    public void deleteAdjacentEdge(int index){
        List<Edge> temp = this.getAdjacentEdges();
        temp.remove(index);
    }
}
