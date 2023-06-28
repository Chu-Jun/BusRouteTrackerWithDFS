
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchRouteGUI {
    private JButton findRouteButton;    
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel destinationPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    List<Edge> path;

    public SearchRouteGUI() {

        JButton backButton = new JButton("Back to main page");
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
        JPanel centerPanel = new JPanel (new GridLayout(1,2));
        // centerPanel.add(sourcePanel);
        // centerPanel.add(destinationPanel);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(sourcePanel, BorderLayout.WEST);
        frame.add(destinationPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        headerPanel.setBackground(new Color(0x84a98c));
        sourcePanel.setBackground(new Color(0xcad2c5));
        destinationPanel.setBackground(new Color(0xcad2c5));
        buttonPanel.setBackground(new Color(0xcad2c5));
        footerPanel.setBackground(new Color(0x84a98c));
        
       
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0x2f3e46));
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
        // JTextField sourceTextField = new JTextField();
        // sourceTextField.setColumns(20);
        // sourcePanel.add(sourceTextField);
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
        // JTextField destinationTextField = new JTextField();
        // destinationTextField.setColumns(20);
        // destinationPanel.add(destinationTextField);

        destinationList.setPrototypeDisplayValue("Select station that you prefer:  ");
        destinationPanel.add(destinationList);

        findRouteButton = new JButton("Find Route");
        findRouteButton.setFont(new Font("Arial", Font.BOLD,15));
        findRouteButton.setBackground (new Color (0x354f52));
        findRouteButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(findRouteButton);

        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x354f52));
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

        findRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepthFirstSearch searchObj = new DepthFirstSearch();
                searchObj.edges = null;
                
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

                path = searchObj.findPathDFS(sourceVertex, destinationVertex);
                String[] stationInPath = new String[path.size()];

                for(int i=0; i<path.size(); i++){
                    Edge temp = path.get(i);
                    Vertex vtemp = temp.getDestination();
                    stationInPath[i] = vtemp.getStationName(0);
                }

                String message = "Route from " + sourceStop + " to " + destinationStop + " found!\n"
                + "You may go through station below to reach the destination: \n"+  sourceStop + "\n";

                for(int i=0; i<stationInPath.length; i++){
                    message += stationInPath[i] + "\n";
                }

                JOptionPane.showMessageDialog(null,
                        message,
                        "Route Found",
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
