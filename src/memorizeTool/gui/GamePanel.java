package memorizeTool.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
    private int points;  // Number of points the user has
    private int round;  // Current round (number of words missed)
    private ArrayList<String> originalTextWords;  // Original words of the text
    private int totalWords;  // Total number of words in the text
    private JTextPane gameTextPane;  // Pane to display the game text with missing words
    private ArrayList<Integer> list; // List of indices of the words to be guessed
    private StatusPanel statusPanel;
    private JFrame frame;
    private List<JTextField> userInputFields;  // List to store user input fields
    private Image bgImage;  // Background image

    public GamePanel(String inputText, int p, int r, StatusPanel statusPanel, JFrame frame) {
        //--------------------------------------------------------------------
        
        
        //--------------------------------------------------------------------------
        setLayout(new BorderLayout()); // Set the layout for the panel
        this.frame = frame;
        points = p;  // Starting points
        round = r;  // Starting round
        originalTextWords = new ArrayList<>();  // Store the original words
        Collections.addAll(originalTextWords, inputText.split(" ")); // Split the inputText into words
        totalWords = originalTextWords.size();  // Get total number of words
        list = new ArrayList<>();
        userInputFields = new ArrayList<>();
        this.statusPanel = statusPanel;

        // Create text pane for displaying game text
        gameTextPane = new JTextPane();
        gameTextPane.setEditable(false);  // Make the text pane non-editable initially
        updateGameText();  // Update game text initially
        add(new JScrollPane(gameTextPane), BorderLayout.CENTER); // Add text pane with scroll
    }

    
    

    // Method to update the game text based on the current round
    private void updateGameText() {
        List<String> wordsToDisplay = new ArrayList<>(originalTextWords);

        // Ensure at least one word is hidden based on current round
        int wordsToHide = Math.max(round * totalWords / 8, 1);

        list.clear(); // Clear previous indices
        Random random = new Random();
        while (list.size() < wordsToHide) {
            int randomNumber = random.nextInt(totalWords);
            if (!list.contains(randomNumber)) { // Prevent duplicates
                list.add(randomNumber);
            }
        }

        list.sort(null);
        StyledDocument doc = gameTextPane.getStyledDocument();
        doc.setCharacterAttributes(0, doc.getLength(), gameTextPane.getStyle(StyleContext.DEFAULT_STYLE), true);

        SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(defaultStyle, Color.BLACK);

        SimpleAttributeSet editableStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(editableStyle, Color.BLUE);

        gameTextPane.setText(""); // Clear the current text

        for (int i = 0; i < totalWords; i++) {
            if (list.contains(i)) {
                JTextField textField = new JTextField("Guess word " + (list.indexOf(i) + 1), 10);
                textField.setForeground(Color.GRAY); // Set hint text color
                final int currenti = i;

                // Add a flag to track if the field has been guessed
                textField.putClientProperty("guessed", false);

                // Focus Listener to handle hint visibility
                textField.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent e) {
                        if (textField.getText().equals("Guess word " + (list.indexOf(currenti) + 1))) {
                            textField.setText("");
                            textField.setForeground(Color.BLACK); // Reset text color
                        }
                    }
                    
                    public void focusLost(java.awt.event.FocusEvent e) {
                        if (textField.getText().isEmpty()) {
                            textField.setForeground(Color.GRAY); // Reset hint color
                            textField.setText("Guess word " + (list.indexOf(currenti) + 1));
                        }
                    }
                });

                textField.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            // Check if the field has already been guessed
                            if (!(Boolean) textField.getClientProperty("guessed")) {
                                checkGuess(currenti, textField);
                                textField.setEditable(false);
                                textField.setBackground(textField.getBackground());
                                textField.putClientProperty("guessed", true);
                            }
                        }
                    }
                });

                userInputFields.add(textField);
                gameTextPane.insertComponent(textField);
            } else {
                try {
                    doc.insertString(doc.getLength(), wordsToDisplay.get(i) + " ", defaultStyle);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkGuess(int index, JTextField textField) {
        String correctAnswer = originalTextWords.get(index);
        String userInput = textField.getText();

        // Check if the user's guess is correct
        if (userInput.equalsIgnoreCase(correctAnswer)) {
            points++; // Increase points by 1
            textField.setBackground(Color.GREEN); // Set background color to green
        } else {
            points--; // Decrease points by 1
            textField.setBackground(Color.RED); // Set background color to red
        }

        // Update the status panel
        statusPanel.updatePoints(points);

        // Check for game over condition
        checkGameOver(frame);

        // Check if all guesses have been made
        if (checkAllGuesses()) {
            // Automatically proceed to the next round after a brief delay
            Timer timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    proceedToNextRound();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    // Method to check if all guesses were made
    private boolean checkAllGuesses() {
        for (int i = 0; i < userInputFields.size(); i++) {
            if (userInputFields.get(i).getText().equals("Guess word " + (i+1))) {
                return false;
            }
        }
        userInputFields.clear();
        return true; // All guesses submitted
    }

    private void proceedToNextRound() {
        round++;
        statusPanel.updateRound(round);
        if (round < 8) {
            updateGameText(); // Update game text for the next round
        } else {
            // Handle game end situation
            displayCongratulations();
        }
    }
    
    private void displayCongratulations() {
        gameTextPane.setText("Congratulation! Total Points: " + points);
    
       // Load the image
ImageIcon congratsImage = null;
try {
    // Load the image from the file
    Image img = ImageIO.read(new File("C:\\Users\\USP\\Desktop\\finally_plz.png"));

    // Scale the image to fit within the panel dimensions
    int panelWidth = getWidth();         // Get the width of the panel
    int panelHeight = getHeight() ;   // Use half of the panel height (or adjust as needed)

    // Scale the image smoothly
    Image scaledImage = img.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);

    // Create an ImageIcon with the scaled image
    congratsImage = new ImageIcon(scaledImage);

} catch (IOException e) {
    e.printStackTrace();
}
    
        // Create a JLabel with the image
        if (congratsImage != null) {
            JLabel imageLabel = new JLabel(congratsImage);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the image
    
            // Add the image label to the panel
            add(imageLabel, BorderLayout.SOUTH);
        }
    
        // Revalidate and repaint the panel to make sure the image shows up
        revalidate();
        repaint();
    }

    private void checkGameOver(JFrame mainFrame) {
        if (points <= 0) {
            // Display a dialog box
            JOptionPane.showMessageDialog(this, "Game Over! Total Points: " + points,
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);

            // Close both the GamePanel and the input text window
            if (mainFrame != null) {
                mainFrame.dispose(); // Close the main application window
            }
        }
    }
}
