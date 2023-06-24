
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// public class StartApplication{
    
//     public void startApplication(){
//         JFrame frame = new JFrame("Bus Route Tracking Application");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(300,300);
//         JButton button = new JButton("Press");
//         frame.getContentPane().add(button); // Adds Button to content pane of frame
//         frame.setVisible(true);
        
//     }

//     public static void main(String[] args) {
//         StartApplication start= new StartApplication();
//         start.startApplication();
//         Graph graph = new Graph();       

        // // Create vertices
        // Vertex v1 = new Vertex(1);
        // Vertex v2 = new Vertex(2);
        // Vertex v3 = new Vertex(3);
        // Vertex v4 = new Vertex(4);
        // Vertex v5 = new Vertex(5);

        // // Add vertices to the graph
        // graph.addVertex(v1);
        // graph.addVertex(v2);
        // graph.addVertex(v3);
        // graph.addVertex(v4);
        // graph.addVertex(v5);

        
        // // Create edges
        // Edge e1 = new Edge(v1, v2);
        // Edge e2 = new Edge(v2, v3);
        // Edge e3 = new Edge(v3, v4);
        // Edge e4 = new Edge(v4, v5);
        // Edge e5 = new Edge(v1, v3);
        // Edge e6 = new Edge(v2, v4);

        // // Add edges to the vertices
        // v1.addAdjacentEdge(e1);
        // v2.addAdjacentEdge(e2);
        // v3.addAdjacentEdge(e3);
        // v4.addAdjacentEdge(e4);
        // v1.addAdjacentEdge(e5);
        // v2.addAdjacentEdge(e6);

        
//         // Perform DFS or any other operations on the graph
//         DepthFirstSearch dfs = new DepthFirstSearch();
//         List<Edge> shortestPath = dfs.findPathDFS(v1, v3, graph);

//         System.out.println("V1: "+ v1);
//         System.out.println("V3: "+ v3);
//         System.out.println("The shortest path from "+v1+" to "+v3+": ");
//         for(int i=0; i<shortestPath.size(); i++){
//             System.out.println(shortestPath.get(i));
//         }
//     }

// }


public class StartApplication extends JFrame {
    public static JFrame frame = new JFrame();
    JButton searchButton = new JButton("Search Route");
    JButton addButton = new JButton("Add Route");
    JButton addStationButton = new JButton("Add New Station");
    JPanel panel1 = new JPanel();
    public static Graph graph = new Graph();

    public StartApplication() {

        initializeBasicGraph();
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();
        ClickListener click3 = new ClickListener();

        searchButton.addActionListener(click1);
        addButton.addActionListener(click2);
        addStationButton.addActionListener(click3);
        panel1.add(addStationButton);
        panel1.add(searchButton);
        panel1.add(addButton);
        
        frame.add(panel1, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == searchButton)
            {
                frame.setVisible(false);
                new SearchRouteGUI();
            }
            else if(e.getSource() == addButton){
                frame.setVisible(false);
                new AddRouteGUI();
            }
            else if(e.getSource() == addStationButton){
                frame.setVisible(false);
                new AddStationGUI();
                
            } 
            

        }
    }


    public void initializeBasicGraph(){
        // Create vertices
        Vertex gelugor = new Vertex(0, "Gelugor");
        Vertex bayanLepas = new Vertex(1, "Bayan Lepas");
        Vertex bayanBaru = new Vertex(2, "Bayan Baru");
        Vertex USM = new Vertex(3, "USM");
        Vertex Georgetown = new Vertex(4, "Georgetown");

        // Add vertices to the graph
        graph.addVertex(gelugor);
        graph.addVertex(bayanLepas);
        graph.addVertex(bayanBaru);
        graph.addVertex(USM);
        graph.addVertex(Georgetown);

        
        // Create edges
        Edge e1 = new Edge(gelugor, bayanLepas);
        Edge e2 = new Edge(bayanLepas, bayanBaru);
        Edge e3 = new Edge(gelugor, bayanBaru);
        Edge e4 = new Edge(bayanBaru, Georgetown);
        Edge e5 = new Edge(gelugor, USM);
        Edge e6 = new Edge(USM, Georgetown);

        // Add edges to the vertices
        USM.addAdjacentEdge(e6);
        gelugor.addAdjacentEdge(e1);
        bayanLepas.addAdjacentEdge(e2);
        gelugor.addAdjacentEdge(e3);
        bayanBaru.addAdjacentEdge(e4);
        gelugor.addAdjacentEdge(e5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartApplication();
            }
        });
    }
}


