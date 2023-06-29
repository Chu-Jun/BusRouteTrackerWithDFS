
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddRouteGUI {
    private JButton addRouteButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel destinationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();

    public AddRouteGUI() {

        JFrame frame = new JFrame();
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.setTitle("Bus Route Tracking App");
        String[] station = new String[StartApplication.graph.countVertices()];
        System.out.println(StartApplication.graph.countVertices());
        List<Vertex> list= StartApplication.graph.getVertices();
        for(int i=0; i<StartApplication.graph.countVertices(); i++){
            
            Vertex temp = list.get(i);
            station[i] = temp.getStationName(0);
        }

        final JComboBox<String> stationList = new JComboBox<String>(station);
        final JComboBox<String> destinationList = new JComboBox<String>(station);

        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
    
        //Set Contents Panel 
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(destinationPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        destinationPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
       
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        JLabel sourceLabel = new JLabel();
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

        JLabel destinationLabel = new JLabel();
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

        addRouteButton = new JButton("Add Route");
        addRouteButton.setFont(new Font("Arial", Font.BOLD,15));
        addRouteButton.setBackground (new Color (0x6096B4));
        addRouteButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(addRouteButton);

        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(backButton);

        JLabel footerLabel = new JLabel();
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        frame.add(panel);
        frame.setVisible(true);

        addRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceStop = String.valueOf(stationList.getSelectedItem());
                String destinationStop = String.valueOf(destinationList.getSelectedItem());

                Vertex sourceVertex = list.get(0), destinationVertex = list.get(0);

                for(int i=1; i<station.length; i++){
                    if(sourceStop == station[i]){
                        //int stationIndex = i;
                        sourceVertex = list.get(i);
                    }if(destinationStop == station[i]){
                        //int stationIndex = i;
                        destinationVertex = list.get(i);
                    }
                }

                Edge e1 = new Edge(sourceVertex, destinationVertex);
                sourceVertex.addAdjacentEdge(e1);
                destinationVertex.addAdjacentEdge(e1);


                // Perform route finding logic here

                JOptionPane.showMessageDialog(null,
                        "Route from " + sourceStop + " to " + destinationStop + " is successfully added!",
                        "Route added",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartApplication.frame.setVisible(true);
            }
        });
        
    }
}
