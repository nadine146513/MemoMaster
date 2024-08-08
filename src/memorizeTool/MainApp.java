package memorizeTool;

import java.util.Scanner;

import javax.swing.*;

import memorizeTool.gui.MainFrame;
//this is a comment
public class MainApp {
	private static String filePath; 
    public static void main(String[] args) {
    	
        // Set the look and feel of the GUI to the system's default
        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception if look and feel not supported
        }

        try
        { 
            filePath = "music.au"; 
            AudioPlayer audioPlayer =  
                            new AudioPlayer(filePath); 
              
            audioPlayer.play(); 
            
              
            
        }  
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          } 
        
        // Instantiate and display the main application frame
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true); // Make the main frame visible
    }
}
