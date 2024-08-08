package memorizeTool.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

class MyTextArea extends JTextArea {
    private Image img;

    public MyTextArea(int rows, int columns) {
        super(rows, columns);
        try {
            img = ImageIO.read(new File("TextBackground.png")); // Update this path to your image
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        super.paintComponent(g);
    }
}

