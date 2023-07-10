
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// RemoveRoute to remove route according to admin selection
public class RemoveRoute {

    // Declare and initialize variable
    private JButton removeRouteButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel destinationPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JLabel destinationLabel = new JLabel();

    public RemoveRoute() {

        // Set frame properties
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());

        // Get list of station availabe for the drop down list
        String[] station = new String[StartApplication.graph.countVertices()];
        System.out.println(StartApplication.graph.countVertices());
        List<Vertex> list= StartApplication.graph.getVertices();
        for(int i=0; i<StartApplication.graph.countVertices(); i++){
            Vertex temp = list.get(i);
            station[i] = temp.getStationName(0);
        }

        // Declare the drop down component
        final JComboBox<String> stationList = new JComboBox<String>(station);
        final JComboBox<String> destinationList = new JComboBox<String>(station);
    
        //Set Contents Panel 
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(destinationPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add the buttonPanel and footerPanel to the bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);

        // Set background colour for all frame
        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        destinationPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
        // Set properties of header section
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Set properties of the source section
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

        // Set properties of the destination section
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

        // Set properties of the remove route button
        removeRouteButton = new JButton("Remove Route");
        removeRouteButton.setFont(new Font("Arial", Font.BOLD,15));
        removeRouteButton.setBackground (new Color (0x6096B4));
        removeRouteButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(removeRouteButton);

        // Set properties of the back button
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

         // Set frame visibility
        frame.setVisible(true);

        removeRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the station name involved
                String sourceStop = String.valueOf(stationList.getSelectedItem());
                String destinationStop = String.valueOf(destinationList.getSelectedItem());

                Vertex sourceVertex = list.get(0), destinationVertex = list.get(0);

                // Get the vertex for the station
                for(int i=0; i<station.length; i++){
                    if(sourceStop == station[i]){
                        sourceVertex = list.get(i);
                    }if(destinationStop == station[i]){
                        destinationVertex = list.get(i);
                    }
                }

                // Declare and initialize variable
                List<Edge> edgeList = sourceVertex.getAdjacentEdges();
                Edge edgeToRemove = null;
                int indexOfEdge = -999;

                // Use for loop to find the edge between the two vertex
                for(int i=0; i<edgeList.size(); i++){
                    // If the edge exist
                    if(edgeList.get(i).getDestination()==destinationVertex){
                        // remove the edge
                        indexOfEdge = i;
                        edgeToRemove = edgeList.get(i);
                    }else if(i<(edgeList.size()-1) && edgeToRemove == null){
                        // If the edge do not exits, prompt user that the operation fail
                        JOptionPane.showMessageDialog(null,
                        "Route from " + sourceStop + " to " + destinationStop + " does not exist.",
                        "Route cannot be removed",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // If the edge has been succesfully removed, promp user
                if(edgeToRemove!=null){
                    sourceVertex.deleteAdjacentEdge(indexOfEdge);
                    JOptionPane.showMessageDialog(null,
                        "Route from " + sourceStop + " to " + destinationStop + " has been removed.",
                        "Route removed successfully!",
                        JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        // Implement function to bring user to main page after pressing the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartApplication.frame.setVisible(true);
            }
        });
        
    }
}
