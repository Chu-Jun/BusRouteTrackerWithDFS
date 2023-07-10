
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {

    // Declare the variable and components
    public static JFrame frame = new JFrame();
    JButton addRouteButton = new JButton("Add Route");
    JButton addStationButton = new JButton("Add New Station");
    JButton removeRouteButton = new JButton("Remove Route");
    JButton removeStationButton = new JButton("Remove Station");
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public AdminPage() {

        // Fix the size and layout of frame
        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.WEST);

        // Set the background colour of the panel
        headerPanel.setBackground(new Color(0x6096B4));
        buttonPanel.setBackground(new Color(0xBDCDD6));

        // Create header section for the application and set its alignment, font and font colour
        JLabel headerLabel = new JLabel();
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 37));
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
        buttons.add(addStationButton, gbc);
        buttons.add(addRouteButton, gbc);
        buttons.add(removeRouteButton, gbc);
        buttons.add(removeStationButton, gbc);
        buttons.add(backButton, gbc);
        gbc.weighty = 1;

        // Set the properties of the addStationButton
        addStationButton.setForeground(Color.white);
        addStationButton.setBackground(new Color(0x6096B4));
        addStationButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        addStationButton.setPreferredSize(new Dimension(200, 50));

        // Set the properties of the addRouteButton
        addRouteButton.setForeground(Color.white);
        addRouteButton.setBackground(new Color(0x6096B4));
        addRouteButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        addRouteButton.setPreferredSize(new Dimension(200, 50));

        // Set the properties of the removeRouteButton
        removeRouteButton.setForeground(Color.white);
        removeRouteButton.setBackground(new Color(0x6096B4));
        removeRouteButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        removeRouteButton.setPreferredSize(new Dimension(200, 50));

        // Set the properties of the removeStationButton
        removeStationButton.setForeground(Color.white);
        removeStationButton.setBackground(new Color(0x6096B4));
        removeStationButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        removeStationButton.setPreferredSize(new Dimension(200, 50));

        // Set the properties of the backButton
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(0x6096B4));
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(200, 50));

        // add buttons panel to the buttonPanel and set the size of buttonPanel
        buttonPanel.add(buttons);
        buttonPanel.setPreferredSize(new Dimension(745, 400));
        
        // Declare the ClickListener for the button
        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();
        ClickListener click3 = new ClickListener();
        ClickListener click4 = new ClickListener();
        ClickListener click5 = new ClickListener();

        // Set the addActionListener for each button
        addRouteButton.addActionListener(click1);
        addStationButton.addActionListener(click2);
        removeRouteButton.addActionListener(click3);
        removeStationButton.addActionListener(click4);
        backButton.addActionListener(click5);
        
        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // If user press on the addRouteButton
            if(e.getSource() == addRouteButton){
                // Dispose current frame
                frame.dispose();
                // Start the AddRouteGUI 
                new AddRoute();
            }
            // If user press on the addStationButton
            else if(e.getSource() == addStationButton){
                // Dispose current frame
                frame.dispose();
                // Start the AddStationGUI 
                new AddStation();
                
            }
            // If user press on the removeRouteButton
            else if(e.getSource() == removeRouteButton){
                // Dispose current frame
                frame.dispose();
                // Start the RemoveRouteGUI 
                new RemoveRoute();
            }
            // If user press on the removeStationButton
            else if(e.getSource() == removeStationButton){
                // Dispose current frame
                frame.dispose();
                // Start the RemoveRouteGUI 
                new RemoveStation();
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