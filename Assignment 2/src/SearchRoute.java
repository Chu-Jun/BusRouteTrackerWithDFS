
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.text.DecimalFormat;

// Search Route that use DFS to find the path available between two vertex
public class SearchRoute {
    // Declare and initialize the variable
    JFrame frame = new JFrame();
    private JButton findRouteButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel destinationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JLabel destinationLabel = new JLabel();
    JLabel footerLabel = new JLabel();
    List<Edge> path;

    public SearchRoute() {

        // Set frame properties
        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(destinationPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Get list of vertex for the drop down list
        String[] station = new String[StartApplication.graph.countVertices()];

        System.out.println(StartApplication.graph.countVertices());
        List<Vertex> list= StartApplication.graph.getVertices();
        for(int i=0; i<StartApplication.graph.countVertices(); i++){
            
            Vertex temp = list.get(i);
            station[i] = temp.getStationName(0);
        }

        final JComboBox<String> stationList = new JComboBox<String>(station);
        final JComboBox<String> destinationList = new JComboBox<String>(station);

        // Add buttonPanel and footerPanel to the bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        
        // Set the background for the panel
        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        destinationPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));   
       
        // Set properties for the header section
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Set the properties for the source section
        sourceLabel.setText("Source Stop:");
        sourceLabel.setHorizontalTextPosition(JLabel.CENTER);
        sourceLabel.setVerticalTextPosition(JLabel.BOTTOM);
        sourceLabel.setForeground(new Color(0x2f3e46)); //set font color
        sourceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setHorizontalAlignment (JLabel.LEFT);
        sourcePanel.add(sourceLabel);
        stationList.setPrototypeDisplayValue("Select station that you prefer:  ");
        sourcePanel.add(stationList);

        // Set the properties of destination section
        destinationLabel.setText("Destination Stop:");
        destinationLabel.setHorizontalTextPosition(JLabel.CENTER);
        destinationLabel.setVerticalTextPosition(JLabel.BOTTOM);
        destinationLabel.setForeground(new Color(0x2f3e46)); //set font color
        destinationLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        destinationLabel.setVerticalAlignment(JLabel.CENTER);
        destinationLabel.setHorizontalAlignment (JLabel.LEFT);
        destinationPanel.add(destinationLabel);
        destinationList.setPrototypeDisplayValue("Select station that you prefer:  ");
        destinationPanel.add(destinationList);

        // Set the properties of the findRouteButton
        findRouteButton = new JButton("Find Route");
        findRouteButton.setFont(new Font("Arial", Font.BOLD,15));
        findRouteButton.setBackground (new Color (0x6096B4));
        findRouteButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(findRouteButton);

        // Set the properties of the backButton
        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(backButton);

        // Set the properties of the footer section
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        // Set frame visibility to true
        frame.setVisible(true);

        findRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the object of DepthFirstSearch class to call the depthfirstsearch function later
                DepthFirstSearch searchObj = new DepthFirstSearch();
                DecimalFormat df = new DecimalFormat("0.00");
                searchObj.edges = null;
                
                // Get the station name of the station selected by user
                String sourceStop = String.valueOf(stationList.getSelectedItem());
                String destinationStop = String.valueOf(destinationList.getSelectedItem());

                Vertex sourceVertex = list.get(0), destinationVertex = list.get(0);

                // Get the vertex of the station selected
                for(int i=1; i<station.length; i++){
                    if(sourceStop == station[i]){
                        sourceVertex = list.get(i);
                    }if(destinationStop == station[i]){
                        destinationVertex = list.get(i);
                    }
                }

                // Find path between the two vertex by calling the findPathDFS function 
                // and pass the sourcevertex and destination vertex as argument
                path = searchObj.findPathDFS(sourceVertex, destinationVertex);
                // No path found
                if(path == null){
                    // Prompt user that no path exists
                    String message = "Route from " + sourceStop + " to " + destinationStop + " is not available";
                    JOptionPane.showMessageDialog(null,
                        message,
                        "Route Not Found",
                        JOptionPane.INFORMATION_MESSAGE);
                        return;
                }
                String[] stationInPath = new String[path.size()];
                double busFare=0.00;

                // Get the bus fare for each edge and accumulate it
                for(int i=0; i<path.size(); i++){
                    Edge temp = path.get(i);
                    Vertex vtemp = temp.getDestination();
                    busFare += temp.getFare();
                    stationInPath[i] = vtemp.getStationName(0);
                }

                // Display the path available between the two vertex to  user along with the bus fare
                String message = "Route from " + sourceStop + " to " + destinationStop + " found!\n"
                + "You may go through station below to reach the destination: \n"+  sourceStop + "\n";

                for(int i=0; i<stationInPath.length; i++){
                    message += stationInPath[i] + "\n";
                }

                message += "\nThe bus fare is RM " + df.format(busFare);

                JOptionPane.showMessageDialog(null,
                        message,
                        "Route Found",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // Bring user back to the main page after they press on the backButton
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartApplication.frame.setVisible(true);
            }
        });
        
    }
}
