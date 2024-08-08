package memorizeTool.gui;


import javax.swing.*;
import java.awt.*;



public class StatusPanel extends JPanel {
    private JLabel pointsLabel;
    private JLabel roundLabel;
    private int points;
    private int round;

    public StatusPanel(int initialPoints, int round) {
        this.points = initialPoints;
        this.round = round;

        setLayout(new GridLayout(2, 1)); // Arrange labels in a vertical layout

        pointsLabel = new JLabel("Points: " + points);
        roundLabel = new JLabel("Round: " + round +"/8");

        // Add the labels to the panel
        add(pointsLabel);
        add(roundLabel);
        
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        roundLabel.setFont(new Font("Arial", Font.BOLD, 20));
    }

    // Method to update points
    public void updatePoints(int newPoints) {
        this.points = newPoints;
        pointsLabel.setText("Points: " + points);
    }

    // Method to update attempts left
    public void updateRound(int newRound) {
        this.round = newRound;
        roundLabel.setText("Round: " + newRound+"/8");
    }
}