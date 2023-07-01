
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame {

    // Declare the variable and components
    public static JFrame frame = new JFrame();
    JButton searchRouteButton = new JButton("Search Route");
    JButton searchStationButton = new JButton("Search Station");
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();

    public UserPage() {

        // Set the size and layout of the frame
        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.WEST);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background colour of the panel
        headerPanel.setBackground(new Color(0x6096B4));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));

        // Create header section for the application and set its alignment, font and font colour
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);
        
        // Arrange the function option using the GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Declare the buttons panel and set its layout
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(searchStationButton, gbc);
        buttons.add(searchRouteButton, gbc);
        buttons.add(backButton, gbc);
        gbc.weighty = 1;

        // Set the properties of the searchStationButton
        searchStationButton.setForeground(Color.white);
        searchStationButton.setBackground(new Color(0x6096B4));
        searchStationButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchStationButton.setPreferredSize(new Dimension(200, 80));

        // Set the properties of the searchRouteButton
        searchRouteButton.setForeground(Color.white);
        searchRouteButton.setBackground(new Color(0x6096B4));
        searchRouteButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchRouteButton.setPreferredSize(new Dimension(200, 80));

        // Set the properties of the backButton
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(0x6096B4));
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(200, 80));

        // add buttons panel to the buttonPanel and set the size of buttonPanel
        buttonPanel.add(buttons);
        buttonPanel.setPreferredSize(new Dimension(745, 400));

        // Create footer section for the application and set its properties such as its position, font and font colour
        JLabel footerLabel = new JLabel();
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Declare the ClickListener for the button
        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();
        ClickListener click3 = new ClickListener();

        // Set the addActionListener for each button
        searchRouteButton.addActionListener(click1);
        searchStationButton.addActionListener(click2);
        backButton.addActionListener(click3);
        
        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // If user press on the searchRouteButton
             if(e.getSource() == searchRouteButton){
                 // Dispose current frame
                frame.dispose();
                // Start the SearchRouteGUI
                new SearchRouteGUI();
            }
            // If user press on the searchStationButton
            else if(e.getSource() == searchStationButton){
                // Dispose current frame
                frame.dispose();
                // Start the SearchStationGUI
                new SearchStationGUI();
                
            } 
            // If user press on the backButton
            else if(e.getSource() == backButton){
                // Dispose current frame
                frame.dispose();
                // Set the main page's visibility as true
                StartApplication.frame.setVisible(true);
            }
        }
    }
    
}