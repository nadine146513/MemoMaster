package memorizeTool.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundImage extends JPanel{
	Image pic;
	public BackgroundImage() {
		 try {
			pic = ImageIO.read(new File("TextBackground.png"));
		 } catch (IOException e) {
	            System.out.println(e.toString());
	     }
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        g.drawImage(pic, 0, 0, getWidth(), getHeight(), null);
        super.paintComponent(g);
    }

}
