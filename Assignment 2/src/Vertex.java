import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int index;
    public ArrayList<String> station = new ArrayList<String>();
    private List<Edge> adjacentEdges;

    public Vertex(int index, String stationName) {
        this.index = index;
        addStationName(stationName);
        adjacentEdges = new ArrayList<>();
    }

    public void addStationName(String name){
        station.add(0, name);
    }

    public Vertex() {
    }

    public int getIndex() {
        return index;
    }

    public String getStationName(int stationIndex) {
        return station.get(stationIndex);
    }

    public void addAdjacentEdge(Edge edge) {
        adjacentEdges.add(edge);
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }
}
