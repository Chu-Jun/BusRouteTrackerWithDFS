
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame {
    public static JFrame frame = new JFrame();
    JButton searchRouteButton = new JButton("Search Route");
    JButton searchStationButton = new JButton("Search Station");
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel footerPanel = new JPanel();

    public UserPage() {

        frame.setResizable(false);
        frame.setTitle("Bus Route Tracking App");
        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerPanel.setBackground(new Color(0x6096B4));
        buttonPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));

        JLabel headerLabel = new JLabel();
        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(searchStationButton, gbc);
        buttons.add(searchRouteButton, gbc);
        buttons.add(backButton, gbc);
        gbc.weighty = 1;

        searchStationButton.setForeground(Color.white);
        searchStationButton.setBackground(new Color(0x6096B4));
        searchStationButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchStationButton.setPreferredSize(new Dimension(200, 80));

        searchRouteButton.setForeground(Color.white);
        searchRouteButton.setBackground(new Color(0x6096B4));
        searchRouteButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchRouteButton.setPreferredSize(new Dimension(200, 80));

        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(0x6096B4));
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(200, 80));


        buttonPanel.add(buttons);
        frame.add(buttonPanel, BorderLayout.WEST);
        buttonPanel.setPreferredSize(new Dimension(745, 400));

        JLabel footerLabel = new JLabel();
        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();
        ClickListener click3 = new ClickListener();

        searchRouteButton.addActionListener(click1);
        searchStationButton.addActionListener(click2);
        backButton.addActionListener(click3);
        
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
             if(e.getSource() == searchRouteButton){
                frame.dispose();
                new SearchRouteGUI();
            }
            else if(e.getSource() == searchStationButton){
                frame.dispose();
                new SearchStationGUI();
                
            } 
            else if(e.getSource() == backButton){
                frame.dispose();
                StartApplication.frame.setVisible(true);
            }
        }
    }
    
}