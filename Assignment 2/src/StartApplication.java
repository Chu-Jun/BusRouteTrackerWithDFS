
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class StartApplication extends JFrame {
    public static JFrame frame = new JFrame();
    JButton AdminButton = new JButton("Admin");
    JButton UserButton = new JButton("User");
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel adminPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    public static Graph graph = new Graph();
    JLabel headerLabel = new JLabel();
    JLabel footerLabel = new JLabel();

    public StartApplication() throws IOException {
        initializeBasicGraph();
        System.out.println(graph.countVertices());
        frame.setTitle("Bus Route Tracking App");
        frame.setResizable(false);

        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(adminPanel, BorderLayout.WEST);
        frame.add(userPanel, BorderLayout.EAST);
        frame.add(footerPanel, BorderLayout.SOUTH);

        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        AdminButton.setForeground(Color.white);
        AdminButton.setBackground(new Color(0x6096B4));
        AdminButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        AdminButton.setPreferredSize(new Dimension(100, 100));
        adminPanel.setPreferredSize(new Dimension(367, 400));
        adminPanel.add(AdminButton);

        UserButton.setForeground(Color.white);
        UserButton.setBackground(new Color(0x6096B4));
        UserButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        UserButton.setPreferredSize(new Dimension(100, 100));
        userPanel.setPreferredSize(new Dimension(366, 400));
        userPanel.add(UserButton);

        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        headerPanel.setBackground(new Color(0x6096B4));
        adminPanel.setBackground(new Color(0xBDCDD6));
        userPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        

        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();

        AdminButton.addActionListener(click1);
        UserButton.addActionListener(click2);

        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == AdminButton)
            {
                
                frame.setVisible(false);
                new AdminPage();
            }
            else if(e.getSource() == UserButton){
                frame.setVisible(false);
                new UserPage();
            }          
        }
    }
    


    // public void initializeBasicGraph(){
    //     // Create vertices
    //     Vertex gelugor = new Vertex(0, "Gelugor");
    //     Vertex bayanLepas = new Vertex(1, "Bayan Lepas");
    //     Vertex bayanBaru = new Vertex(2, "Bayan Baru");
    //     Vertex USM = new Vertex(3, "USM");
    //     Vertex Georgetown = new Vertex(4, "Georgetown");

    //     // Add vertices to the graph
    //     graph.addVertex(gelugor);
    //     graph.addVertex(bayanLepas);
    //     graph.addVertex(bayanBaru);
    //     graph.addVertex(USM);
    //     graph.addVertex(Georgetown);

        
    //     // Create edges
    //     Edge e1 = new Edge(gelugor, bayanLepas, 1.00);
    //     Edge e2 = new Edge(bayanLepas, bayanBaru, 2.00);
    //     Edge e3 = new Edge(gelugor, bayanBaru, 1.80);
    //     Edge e4 = new Edge(bayanBaru, Georgetown, 2.00);
    //     Edge e5 = new Edge(gelugor, USM, 1.60);
    //     Edge e6 = new Edge(USM, Georgetown, 2.40);

    //     // Add edges to the vertices
    //     USM.addAdjacentEdge(e6);
    //     gelugor.addAdjacentEdge(e1);
    //     bayanLepas.addAdjacentEdge(e2);
    //     gelugor.addAdjacentEdge(e3);
    //     bayanBaru.addAdjacentEdge(e4);
    //     gelugor.addAdjacentEdge(e5);
    // }


    public void initializeBasicGraph() throws IOException{
        Scanner scan = new Scanner(new FileReader("Bus_Route.txt"));
        List<Vertex> stationSaved = StartApplication.graph.getVertices();
        Vertex temp1 = null, temp2 = null;
        int numOfStation=0, counter=0;
        boolean foundSource = false, foundDestination=false;
        List<Edge> edgeList = new ArrayList<Edge>();

        while(scan.hasNext()){
            String curLine = scan.nextLine();
            String[] splitted = curLine.split("\t");
            for(int i=0; i<splitted.length; i++){
                System.out.println(i + " " + splitted[i]);
            }
            String sourceStation = splitted[0].trim();
            String destinationStation = splitted[1].trim();
            String busFare = splitted[2];
            double fee = Double.parseDouble(busFare);

            for(int i=0; i<stationSaved.size(); i++){
                if(sourceStation.equals(stationSaved.get(i).getStationName(0))){
                    temp1 = stationSaved.get(i);
                    foundSource = true;
                }
                if(destinationStation.equals(stationSaved.get(i).getStationName(0))){
                    temp2 = stationSaved.get(i);
                    foundDestination = true;
                }
            }
            if(foundSource == false){
                Vertex newStation = new Vertex(numOfStation, sourceStation);
                graph.addVertex(newStation);
                temp1 = newStation;
            }
            if(foundDestination == false){
                Vertex newDestination = new Vertex(numOfStation, destinationStation);
                graph.addVertex(newDestination);
                temp2 = newDestination;
            }
            edgeList.add(new Edge(temp1, temp2, fee));
            System.out.println("!!!!!!!" + fee);
            temp1.addAdjacentEdge(edgeList.get(counter));
            
            System.out.println(edgeList.get(counter));
            System.out.println("%%%%%5" + temp1.getAdjacentEdges() + "%%%%%");
            counter++;
            foundSource = foundDestination = false;
            temp1 = temp2 = null;

        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartApplication();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("File not found");
                }
            }
        });
    }
}


