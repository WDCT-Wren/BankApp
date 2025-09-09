package SaveUp;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void mainFrame() {
        setTitle("SaveUp Pocket"); // Sets the title to SaveUp Pocket
        setSize(400,300); // Sets the initial size of the application
        setDefaultCloseOperation(EXIT_ON_CLOSE); // The application ends when the GUI gets closed 
    
        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/SaveUp/SaveUpLogo.png")); //imports an image from the same file folder
        Image scaledImage = rawIcon.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT); // 64x64 is the new size
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setIconImage(scaledImage);

        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setText("SaveUp Pocket");
        add(label);

        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        setVisible(true);
    }
    
}
