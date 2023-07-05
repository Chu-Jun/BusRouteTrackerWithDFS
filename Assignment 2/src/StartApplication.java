
//  Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartApplication extends JFrame {
    public static JFrame frame = new JFrame();
    JButton AdminButton = new JButton("Admin");
    JButton UserButton = new JButton("User");
    JButton backButton = new JButton("Back to main page");
    JPanel headerPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel adminPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    public static Graph graph = new Graph();
    JLabel headerLabel = new JLabel();
    JLabel footerLabel = new JLabel();

    public StartApplication() {
        initializeBasicGraph();
        System.out.println(graph.countVertices());
        frame.setTitle("Bus Route Tracking App");
        frame.setResizable(false);

        frame.setSize(745, 400);
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(adminPanel, BorderLayout.WEST);
        frame.add(userPanel, BorderLayout.EAST);
        frame.add(footerPanel, BorderLayout.SOUTH);

        headerLabel.setText("Bus Route Tracking Application");
        headerLabel.setVerticalAlignment (JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0xEEE9DA));
        headerPanel.add(headerLabel);


        // roleLabel.setText("My Role Is:");
        // roleLabel.setVerticalAlignment (JLabel.CENTER);
        // roleLabel.setHorizontalAlignment(JLabel.RIGHT);
        // roleLabel.setFont(new Font("Bowlby One SC", Font.BOLD, 40));
        // roleLabel.setForeground(new Color(0x2f3e46));
        // headerPanel.add(roleLabel);

        AdminButton.setForeground(Color.white);
        AdminButton.setBackground(new Color(0x6096B4));
        AdminButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        AdminButton.setPreferredSize(new Dimension(100, 100));
        adminPanel.setPreferredSize(new Dimension(367, 400));
        adminPanel.add(AdminButton);

        UserButton.setForeground(Color.white);
        UserButton.setBackground(new Color(0x6096B4));
        UserButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        UserButton.setPreferredSize(new Dimension(100, 100));
        userPanel.setPreferredSize(new Dimension(366, 400));
        userPanel.add(UserButton);

        footerLabel.setText("Prepared by Chu Jun & Zee Ching for CPT212 Assignment 2");
        footerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18)); //set font
        footerLabel.setHorizontalTextPosition(JLabel.LEFT);
        footerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        footerPanel.add(footerLabel);

        headerPanel.setBackground(new Color(0x6096B4));
        adminPanel.setBackground(new Color(0xBDCDD6));
        userPanel.setBackground(new Color(0xBDCDD6));
        footerPanel.setBackground(new Color(0x6096B4));
        

        ClickListener click1 = new ClickListener();
        ClickListener click2 = new ClickListener();

        AdminButton.addActionListener(click1);
        UserButton.addActionListener(click2);

        backButton.setFont(new Font("Arial", Font.BOLD,15));
        backButton.setBackground (new Color (0x6096B4));
        backButton.setForeground (new Color (0xcad2c5));
        
        frame.setVisible(true);
    }

    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == AdminButton)
            {
                
                frame.setVisible(false);
                new AdminPage();
            }
            else if(e.getSource() == UserButton){
                frame.setVisible(false);
                new UserPage();
            }          
        }
    }
    


    public void initializeBasicGraph(){
        // Create vertices
        Vertex gelugor = new Vertex(0, "Gelugor");
        Vertex bayanLepas = new Vertex(1, "Bayan Lepas");
        Vertex bayanBaru = new Vertex(2, "Bayan Baru");
        Vertex USM = new Vertex(3, "USM");
        Vertex Georgetown = new Vertex(4, "Georgetown");

        // Add vertices to the graph
        graph.addVertex(gelugor);
        graph.addVertex(bayanLepas);
        graph.addVertex(bayanBaru);
        graph.addVertex(USM);
        graph.addVertex(Georgetown);

        
        // Create edges
        Edge e1 = new Edge(gelugor, bayanLepas);
        Edge e2 = new Edge(bayanLepas, bayanBaru);
        Edge e3 = new Edge(gelugor, bayanBaru);
        Edge e4 = new Edge(bayanBaru, Georgetown);
        Edge e5 = new Edge(gelugor, USM);
        Edge e6 = new Edge(USM, Georgetown);

        // Add edges to the vertices
        USM.addAdjacentEdge(e6);
        gelugor.addAdjacentEdge(e1);
        bayanLepas.addAdjacentEdge(e2);
        gelugor.addAdjacentEdge(e3);
        bayanBaru.addAdjacentEdge(e4);
        gelugor.addAdjacentEdge(e5);
    }


    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartApplication();
            }
        });
    }
}


