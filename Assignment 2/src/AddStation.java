
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddStation {

    // Declare variable and components
    JFrame frame = new JFrame();
    private JButton addStationButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JTextField sourceTextField = new JTextField();
    static JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    int count = 0;

    public AddStation() {

        // Fix the size and layout of frame
        frame.setResizable(false);
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set the title of the interface
        frame.setTitle("Bus Route Tracking App");
        

        // Set background colour of the panel
        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
        // Add the buttonPanel and footerPanel to the bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);

       // Create header for the application and set its alignment, font and font colour
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Create section of new station for the application and set its properties such as alignment, font and font colour
        sourceLabel.setText("New Station:");
        sourceLabel.setHorizontalTextPosition(JLabel.CENTER);
        sourceLabel.setVerticalTextPosition(JLabel.BOTTOM);
        sourceLabel.setForeground(new Color(0x2f3e46)); //set font color
        sourceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setHorizontalAlignment (JLabel.LEFT);
        sourcePanel.add(sourceLabel);
        sourceTextField.setColumns(20);
        sourcePanel.add(sourceTextField);
        sourcePanel.setPreferredSize(new Dimension(745, 400));

        //  Set the addStationButton properties 
        addStationButton = new JButton("Add Station");
        addStationButton.setFont(new Font("Arial", Font.BOLD,15));
        addStationButton.setBackground (new Color (0x6096B4));
        addStationButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(addStationButton);

        //  Set the backButton properties 
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

        //Perform add station function after user clicked the addStationButton
        addStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get the name of the new station from the text field in the source station section
                String Station = sourceTextField.getText();

                // Get list of vertex available to check if the station already exists
                List<Vertex> list = StartApplication.graph.getVertices();
                Boolean found = false;

                // Use for loop to check the whether the station already exists
                for(int i=0; i<list.size(); i++){
                    Vertex temp = list.get(i);
                    String tempStation = temp.getStationName(0);
                    System.out.println(tempStation + " + " + Station);
                    int results = tempStation.compareToIgnoreCase(Station);
                    if(results==0){
                        JOptionPane.showMessageDialog(null,
                        "The station already exists!",
                        "Add station failed",
                        JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                    }
                }
                if(!found){
                    // Create new vertex with the obtained station name
                    Vertex newVertex = new Vertex(count, Station);
                    count++;

                    // Add the vertex to the graph
                    StartApplication.graph.addVertex(newVertex);

                    // Show message to notify user that the station has been added
                    JOptionPane.showMessageDialog(null,
                            "Station " + Station + " is successfully added!",
                            "Station added",
                            JOptionPane.INFORMATION_MESSAGE);
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
