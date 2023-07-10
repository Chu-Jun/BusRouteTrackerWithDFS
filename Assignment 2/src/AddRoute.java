
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// AddRouteGUI that provide admin interface to add new route("edges") to the bus transportation network ("graph")
public class AddRoute{

    // Declare variable and components
    JFrame frame = new JFrame();
    JButton addRouteButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel(new GridLayout(2, 1));
    JPanel destinationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    final JComboBox<String> stationList;
    final JComboBox<String> destinationList;
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JLabel destinationLabel = new JLabel();
    JLabel fareLabel = new JLabel();
    JTextField fareTextField = new JTextField();

    public AddRoute() {

        // Fix the size and layout of frame
        frame.setResizable(false);
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());

        // Set the title of the interface
        frame.setTitle("Bus Route Tracking App");
        String[] station = new String[StartApplication.graph.countVertices()];

        // Get the list of station("vertices") available to let user choose using dropdown list
        List<Vertex> list= StartApplication.graph.getVertices();

        // Get the station name using for loop
        for(int i=0; i<StartApplication.graph.countVertices(); i++){
            Vertex temp = list.get(i);
            station[i] = temp.getStationName(0);
        }

        // Dynamically allocate the dropdown list with the list of station name
        stationList = new JComboBox<String>(station);
        destinationList = new JComboBox<String>(station);
    
        //Set Contents Panel 
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(destinationPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set the background colour of the panel
        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        destinationPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));

        // Add the buttonPanel and footerPanel to the bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);

        // Create header for the application and set its alignment, font and font colour
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Create section of source station for the application and set its properties such as alignment, font and font colour
        sourceLabel.setText("Source Stop:");
        sourceLabel.setHorizontalTextPosition(JLabel.CENTER);
        sourceLabel.setVerticalTextPosition(JLabel.BOTTOM);
        sourceLabel.setForeground(new Color(0x2f3e46)); //set font color
        sourceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setHorizontalAlignment (JLabel.LEFT);
        JPanel temp = new JPanel();
        temp.setBackground(new Color(0xBDCDD6));
        temp.add(sourceLabel);

        stationList.setPrototypeDisplayValue("Select station that you prefer:  ");
        temp.add(stationList);
        

        fareLabel.setText("Bus Fare:   ");
        fareLabel.setHorizontalTextPosition(JLabel.CENTER);
        fareLabel.setVerticalTextPosition(JLabel.BOTTOM);
        fareLabel.setForeground(new Color(0x2f3e46)); //set font color
        fareLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        fareLabel.setVerticalAlignment(JLabel.CENTER);
        fareLabel.setHorizontalAlignment (JLabel.LEFT);
        JPanel temp2 = new JPanel();
        temp2.setBackground(new Color(0xBDCDD6));
        fareTextField.setColumns(20);
        temp2.add(fareLabel);
        temp2.add(fareTextField);

        sourcePanel.add(temp);
        sourcePanel.add(temp2);

        // Create section of destination station for the application and set properties such as its alignment, font and font colour
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

        // Initialize the addRouteButton and set its properties 
        addRouteButton = new JButton("Add Route");
        addRouteButton.setFont(new Font("Arial", Font.BOLD,15));
        addRouteButton.setBackground (new Color (0x6096B4));
        addRouteButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(addRouteButton);

        // Initialize the backButton and set its properties 
        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(backButton);

        // Create footer section for the application and set its properties such as its position, font and font colour
        JLabel footerLabel = new JLabel();
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        // Set the frame visibility to true
        frame.setVisible(true);

        // Perform add route function when the addRouteButton is clicked
        addRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get the station name from the dropdown list
                String sourceStop = String.valueOf(stationList.getSelectedItem());
                String destinationStop = String.valueOf(destinationList.getSelectedItem());
                double fare = Double.parseDouble(fareTextField.getText());

                if(fare<=0){
                    JOptionPane.showMessageDialog(null,
                        "Fare is invalid. Please enter value more than 0.",
                        "Fare invalid!",
                        JOptionPane.INFORMATION_MESSAGE);
                }else{

                    
                    // Declare and initialize the vertex variable
                    Vertex sourceVertex = list.get(0), destinationVertex = list.get(0);

                    // Get the source and destination vertex by comparing the station name using for loop
                    for(int i=1; i<station.length; i++){
                        if(sourceStop == station[i]){
                            sourceVertex = list.get(i);
                        }if(destinationStop == station[i]){
                            destinationVertex = list.get(i);
                        }
                    }

                    // Declare and initialize variable
                    List<Edge> edgeList = sourceVertex.getAdjacentEdges();

                    // Use for loop to find the edge between the two vertex
                    for(int i=0; i<edgeList.size(); i++){
                        // If the edge exist
                        if(edgeList.get(i).getDestination()==destinationVertex){
                            JOptionPane.showMessageDialog(null,
                                    "Route from " + sourceStop + " to " + destinationStop + " already exists!",
                                    "Fail to add the route",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    break;
                        }else{
                            // Create new edge for the source and destination vertex
                            Edge e1 = new Edge(sourceVertex, destinationVertex, fare);

                            // Add the edge to the source vertex's adjacent edges list
                            sourceVertex.addAdjacentEdge(e1);
                            //destinationVertex.addAdjacentEdge(e1);

                            // Show message to notify user that the route is added
                            JOptionPane.showMessageDialog(null,
                                    "Route from " + sourceStop + " to " + destinationStop + " is successfully added!",
                                    "Route added",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        // Back to the main page after user clicked on the backButton
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Dispose currrent frame
                frame.dispose();

                // Set the main page frame visibility as true
                StartApplication.frame.setVisible(true);
            }
        });
        
    }
}
