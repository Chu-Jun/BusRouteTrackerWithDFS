
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveStation {
    JFrame frame = new JFrame();
    private JButton addStationButton; 
    JButton backButton = new JButton("Back to main page");   
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
    JLabel headerLabel = new JLabel();
    JLabel sourceLabel = new JLabel();
    JLabel footerLabel = new JLabel();
    int count = 0;

    public RemoveStation() {

        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");

        String[] station = new String[StartApplication.graph.countVertices()];

        List<Vertex> list= StartApplication.graph.getVertices();
        for(int i=0; i<StartApplication.graph.countVertices(); i++){
            
            Vertex temp = list.get(i);
            station[i] = temp.getStationName(0);
        }

        final JComboBox<String> stationList = new JComboBox<String>(station);
        
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(sourcePanel, BorderLayout.WEST);

        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        headerPanel.setBackground(new Color(0x6096B4));
        sourcePanel.setBackground(new Color(0xBDCDD6));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        
       
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);

        sourceLabel.setText("Station:");
        sourceLabel.setHorizontalTextPosition(JLabel.CENTER);
        sourceLabel.setVerticalTextPosition(JLabel.BOTTOM);
        sourceLabel.setForeground(new Color(0x2f3e46)); //set font color
        sourceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setHorizontalAlignment (JLabel.LEFT);
        sourcePanel.add(sourceLabel);
        stationList.setPrototypeDisplayValue("Select station that you prefer:  ");
        sourcePanel.add(stationList);
        sourcePanel.setPreferredSize(new Dimension(745, 400));

        addStationButton = new JButton("Remove Station");
        addStationButton.setFont(new Font("Arial", Font.BOLD,15));
        addStationButton.setBackground (new Color (0x6096B4));
        addStationButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(addStationButton);

        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(backButton);

        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        frame.setVisible(true);

        addStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String station = String.valueOf(stationList.getSelectedItem());

                List<Vertex> list = StartApplication.graph.getVertices();

                for(int i=0; i<list.size(); i++){
                    Vertex temp = list.get(i);
                    if(temp.getStationName(0) == station){
                        JOptionPane.showMessageDialog(null,
                        "Station " + station + " has been removed!",
                        "Station removed",
                        JOptionPane.INFORMATION_MESSAGE);

                        StartApplication.graph.removeVertex(i);
                    }
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