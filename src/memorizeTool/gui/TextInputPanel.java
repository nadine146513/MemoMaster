package memorizeTool.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TextInputPanel extends JPanel {
    // Attributes
    private MyTextArea textArea; // Custom JTextArea for multi-line text input with background image
    private JButton submitButton; // JButton for submitting the text
    int count = 0;

    // Constructor
    public TextInputPanel(JFrame textInputPanelFrame) {
        // Set layout manager to BorderLayout
        setLayout(new BorderLayout());

        // Initialize the MyTextArea
        textArea = new MyTextArea(10, 30); // Create a MyTextArea with 10 rows and 30 columns
        textArea.setBackground(new Color(1, 1, 1, (float) 0.01));
        textArea.setText("Enter the text you want to memorize");
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textArea.setForeground(Color.gray); // Set hint text color

        // Enable line wrapping and wrap style word
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Focus Listener to handle hint visibility
        textArea.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                count++;
                if ((textArea.getText().equals("Enter the text you want to memorize")) && count > 1) {
                    textArea.setText("");
                    textArea.setForeground(Color.black); // Reset text color
                } else {
                    textArea.transferFocus();
                }
            }

            public void focusLost(FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                    textArea.setForeground(Color.gray); // Reset hint color
                    textArea.setText("Enter the text you want to memorize");
                }
            }
        });

        // Wrap MyTextArea in a JScrollPane for scrolling capability
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER); // Add the scrollPane to the center region of the panel

        // Initialize the submit button
        submitButton = new JButton("Submit"); // Create a JButton labeled "Submit"
        add(submitButton, BorderLayout.SOUTH); // Add the submit button to the southern region of the panel
        Font buttonFont = new Font("Arial", Font.BOLD, 20); // Font name, style, and size
        submitButton.setFont(buttonFont);
        submitButton.setForeground(Color.black); // Set text color
        submitButton.setPreferredSize(new Dimension(200, 50)); // Set button size
        submitButton.setOpaque(false); // Make the button background transparent
        submitButton.setContentAreaFilled(false); // Remove default button background fill
        submitButton.setBorderPainted(false); // Remove button border

        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                // Create a new frame
                JFrame frame = new JFrame("Guess the Missing Words");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create an instance of TextInputPanel
                StatusPanel statusPanel = new StatusPanel(3, 1);
                GamePanel gamePanel = new GamePanel(getInputText(), 3, 1, statusPanel, frame);

                // Add the panel to the frame
                frame.add(gamePanel);
                frame.add(statusPanel, BorderLayout.NORTH);

                // Set frame size and make it visible
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                textInputPanelFrame.dispose();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null); // Center the frame on screen
            }
        });
    }

    // Getter for retrieving the input text
    public String getInputText() {
        return textArea.getText(); // Return the current text in the text area
    }
}
