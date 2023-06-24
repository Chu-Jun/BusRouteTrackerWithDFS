
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStationGUI {
    private JButton addStationButton;    
    JPanel headerPanel = new JPanel();
    JPanel sourcePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    int count = 0;

    public AddStationGUI() {

        JButton backButton = new JButton("Back to main page");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Bus Route Tracking App");
        
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
    
        frame.add(sourcePanel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(footerPanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        headerPanel.setBackground(new Color(0x84a98c));
        sourcePanel.setBackground(new Color(0xcad2c5));
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
        sourceLabel.setText("New Station:");
        sourceLabel.setHorizontalTextPosition(JLabel.CENTER);
        sourceLabel.setVerticalTextPosition(JLabel.BOTTOM);
        sourceLabel.setForeground(new Color(0x2f3e46)); //set font color
        sourceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); //set font
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setHorizontalAlignment (JLabel.LEFT);
        sourcePanel.add(sourceLabel);
        JTextField sourceTextField = new JTextField();
        sourceTextField.setColumns(20);
        sourcePanel.add(sourceTextField);

        addStationButton = new JButton("Add Station");
        addStationButton.setFont(new Font("Arial", Font.BOLD,15));
        addStationButton.setBackground (new Color (0x354f52));
        addStationButton.setForeground (new Color (0xcad2c5));
        buttonPanel.add(addStationButton);

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

        addStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceStop = sourceTextField.getText();
                System.out.println(sourceStop);

                Vertex newVertex = new Vertex(count, sourceStop);
                count++;
                StartApplication.graph.addVertex(newVertex);

                JOptionPane.showMessageDialog(null,
                        "Station " + sourceStop + " is successfully added!",
                        "Station added",
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
