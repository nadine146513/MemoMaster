package memorizeTool.gui;

import javax.swing.*; // Import all Swing components
import java.awt.*; // Import AWT classes for layout management
import java.awt.event.*; // Import AWT event classes for handling events

public class MainFrame extends JFrame { // MainFrame class extends JFrame to create a window
    //------------------------------------------------------------------------------------------------
    public MainFrame() { // Constructor for the MainFrame class
        setTitle("MemoMaster"); // Sets the title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the application when window is closed
        setLocationRelativeTo(null); // Centers the window on the screen

        // Create a JLayeredPane for holding components
        JLayeredPane layeredPane = new JLayeredPane();

        // Create a JPanel for the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("Memorize1.png"); // Update this path to your image
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Draw the image to fill the panel
            }
        };
        backgroundPanel.setBounds(0, 0, getWidth(), getHeight());

        // Component: startButton
        JButton startButton = new JButton("Start"); // Create a JButton for starting the tool
        Font buttonFont = new Font("Arial", Font.BOLD, 50); // Font name, style, and size
        startButton.setFont(buttonFont);
        startButton.setForeground(Color.decode("#FFBF00")); // Set text color to gold
        startButton.setPreferredSize(new Dimension(200, 50)); // Set button size
        startButton.setOpaque(false); // Make the button background transparent
        startButton.setContentAreaFilled(false); // Remove default button background fill
        startButton.setBorderPainted(false); // Remove button border
        
        // Panel to hold the start button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center the button
        buttonPanel.setBounds(0, 0, getWidth(), getHeight());
        buttonPanel.add(startButton);
       
        // Add an ActionListener to the button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                // Create a new frame
                JFrame frame = new JFrame("Text Input");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create an instance of TextInputPanel
                TextInputPanel textInputPanel = new TextInputPanel(frame);

                // Add the panel to the frame
                frame.add(textInputPanel);

                // Set the frame to maximize and make it visible
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // This will maximize the window
                frame.setVisible(true);
                frame.setLocationRelativeTo(null); // Center the frame on screen
            }
        });

        // Add components to the layered pane
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane); // Add the layered pane to the frame

        // Set the initial window size to be maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true); // Make the main frame visible

        // Ensure the background and button panel resize with the window
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                backgroundPanel.setBounds(0, 0, getWidth(), getHeight());
                buttonPanel.setBounds(0, 0, getWidth(), getHeight());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
