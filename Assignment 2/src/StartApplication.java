
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

// Main page of the program
public class StartApplication extends JFrame {

    // Declare and initialize the variable
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

        // Initialize the graph by calling the initializeBasicGraph function that will read the text file
        initializeBasicGraph();

        // Set frane properties
        frame.setTitle("Bus Route Tracking App");
        frame.setResizable(false);
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(adminPanel, BorderLayout.WEST);
        frame.add(userPanel, BorderLayout.EAST);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Set properties of the header section
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Set properties of the AdminButton
        AdminButton.setForeground(Color.white);
        AdminButton.setBackground(new Color(0x6096B4));
        AdminButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        AdminButton.setPreferredSize(new Dimension(100, 100));
        adminPanel.setPreferredSize(new Dimension(367, 400));
        adminPanel.add(AdminButton);

        // Set properties of the UserButton
        UserButton.setForeground(Color.white);
        UserButton.setBackground(new Color(0x6096B4));
        UserButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        UserButton.setPreferredSize(new Dimension(100, 100));
        userPanel.setPreferredSize(new Dimension(366, 400));
        userPanel.add(UserButton);

        // Set properties of the footer section
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        // Set background colur for all panel
        headerPanel.setBackground(new Color(0x6096B4));
        adminPanel.setBackground(new Color(0xBDCDD6));
        userPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
        // Create clicklistener for the buttons
        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();

        AdminButton.addActionListener(click1);
        UserButton.addActionListener(click2);

        // Set the properties of the backButton
        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        
        // Set frame visibility to true
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

    // Initialize the basic graph by reading the text file provided
    public void initializeBasicGraph() throws IOException{
        // Declare the variable
        Scanner scan = new Scanner(new FileReader("Bus_Route.txt"));
        List<Vertex> stationSaved = StartApplication.graph.getVertices();
        Vertex temp1 = null, temp2 = null;
        int numOfStation=0, counter=0;
        boolean foundSource = false, foundDestination=false;
        List<Edge> edgeList = new ArrayList<Edge>();

        // Read the file until the end
        while(scan.hasNext()){
            String curLine = scan.nextLine();
            String[] splitted = curLine.split("\t");
            String sourceStation = splitted[0].trim();
            String destinationStation = splitted[1].trim();
            String busFare = splitted[2];
            double fee = Double.parseDouble(busFare);

            // If the station already exists dont create new vertex
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
            // If the station is not exists create new vertex
            if(foundSource == false){
                Vertex newStation = new Vertex(numOfStation, sourceStation);
                graph.addVertex(newStation);
                temp1 = newStation;
                numOfStation++;
            }
            if(foundDestination == false){
                Vertex newDestination = new Vertex(numOfStation, destinationStation);
                graph.addVertex(newDestination);
                temp2 = newDestination;
                numOfStation++;
            }
            // Create edge between the two station
            edgeList.add(new Edge(temp1, temp2, fee));
            temp1.addAdjacentEdge(edgeList.get(counter));
            
            // Incrememt the counter and initialize the boolean value
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
                    // If the file is not exists show message to notify the user
                    System.out.println("File not found");
                }
            }
        });
    }
}


