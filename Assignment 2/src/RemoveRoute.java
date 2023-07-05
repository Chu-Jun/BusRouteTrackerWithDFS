
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveRoute {
    private JButton addRouteButton;    
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel destinationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JLabel destinationLabel = new JLabel();

    public RemoveRoute() {

        JFrame frame = new JFrame();
        frame.setResizable(false);
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

        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        destinationPanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

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

        addRouteButton = new JButton("Remove Route");
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

        frame.setVisible(true);

        addRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceStop = String.valueOf(stationList.getSelectedItem());
                String destinationStop = String.valueOf(destinationList.getSelectedItem());

                Vertex sourceVertex = list.get(0), destinationVertex = list.get(0);

                for(int i=0; i<station.length; i++){
                    if(sourceStop == station[i]){
                        sourceVertex = list.get(i);
                    }if(destinationStop == station[i]){
                        destinationVertex = list.get(i);
                    }
                }

                List<Edge> edgeList = sourceVertex.getAdjacentEdges();
                Edge edgeToRemove = null;
                int indexOfEdge = -999;

                for(int i=0; i<edgeList.size(); i++){
                    if(edgeList.get(i).getDestination()==destinationVertex){
                        indexOfEdge = i;
                        edgeToRemove = edgeList.get(i);
                    }else if(i<(edgeList.size()-1) && edgeToRemove == null){
                        JOptionPane.showMessageDialog(null,
                        "Route from " + sourceStop + " to " + destinationStop + " does not exist.",
                        "Route cannot be removed",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                if(edgeToRemove!=null){
                    sourceVertex.deleteAdjacentEdge(indexOfEdge);
                    JOptionPane.showMessageDialog(null,
                        "Route from " + sourceStop + " to " + destinationStop + " has been removed.",
                        "Route removed successfully!",
                        JOptionPane.INFORMATION_MESSAGE);
                }

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
