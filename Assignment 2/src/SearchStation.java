
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Search station to according to user input
public class SearchStation {

    // Declare and initialize the variable
    JFrame frame = new JFrame();
    private JButton findStationButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    JPanel footerPanel = new JPanel();
    JLabel headerLabel = new JLabel();
    JLabel stationLabel = new JLabel();
    JLabel footerLabel = new JLabel();
    JTextField stationTextField = new JTextField();
    List<Edge> path;

    public SearchStation() {
        
        // Set frame properties
        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.WEST);
        centerPanel.setPreferredSize(new Dimension(745, 400));

        // Add buttonPanel and footerPanel to bottomPanel
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        
        // Set background colour for all panel
        headerPanel.setBackground(new Color(0x6096B4));
        centerPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
        // Set properties of header section
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        // Set properties of the station section
        stationLabel.setText("Station:");
        stationLabel.setHorizontalTextPosition(JLabel.CENTER);
        stationLabel.setVerticalTextPosition(JLabel.BOTTOM);
        stationLabel.setForeground(new Color(0x2f3e46)); //set font color
        stationLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        stationLabel.setVerticalAlignment(JLabel.CENTER);
        stationLabel.setHorizontalAlignment (JLabel.LEFT);
        centerPanel.add(stationLabel);
        stationTextField.setColumns(20);
        centerPanel.add(stationTextField);

        // Set the properties of the findStationButton
        findStationButton = new JButton("Find Station");
        findStationButton.setFont(new Font("Arial", Font.BOLD,15));
        findStationButton.setBackground (new Color (0x6096B4));
        findStationButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(findStationButton);

        // Set properties of backButton
        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(backButton);

        // Set properties of footer section
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        // Set frame visibility to true
        frame.setVisible(true);

        findStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Get station name from the textfield
                String Station = stationTextField.getText();

                // Get list of vertex in the graph
                List<Vertex> list = StartApplication.graph.getVertices();
                Boolean found = false;

                // Use for loop to check whether the station aready exists in the list of vertex
                for(int i=0; i<list.size(); i++){
                    Vertex temp = list.get(i);
                    String tempStation = temp.getStationName(0);
                    int results = tempStation.compareToIgnoreCase(Station);
                    // If already exists, prompt user
                    if(results==0){
                        JOptionPane.showMessageDialog(null,
                        "The station selected exists!",
                        "Station Found",
                        JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                    }
                }
                // If not found, prompt user that the station is not exists
                if(!found){
                    JOptionPane.showMessageDialog(null,
                    "The station selected does not exists!",
                    "Station Not Found",
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        // Bring user to main page if they click on the backButton
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartApplication.frame.setVisible(true);
            }
        });
        
    }
}
