package SaveUp;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void mainFrame() {

        setTitle("SaveUp Pocket"); // Sets the title to SaveUp Pocket
        setSize(1080, 720); // Sets the initial size of the application
        setDefaultCloseOperation(EXIT_ON_CLOSE); // The application ends when the GUI gets closed 

        setExtendedState(MAXIMIZED_BOTH); //Automatically full screens the window of the application once it is started
        setLocationRelativeTo(null); //Centers the window after opening the application on full screen

    
        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/SaveUp/AppIcon.png")); //imports an image from the same file folder
        Image scaledImage = rawIcon.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT); // 64x64 is the new size
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        ImageIcon rawAppIcon = new ImageIcon(getClass().getResource("/SaveUp/AppIcon.png"));
        Image appIcon = rawAppIcon.getImage().getScaledInstance(4096, 4096, Image.SCALE_AREA_AVERAGING);
        setIconImage(appIcon);

        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        label.setText("SaveUp Pocket");
        label.setForeground(new Color(255, 255, 255));
        add(label);

        getContentPane().setBackground(new Color(82, 82, 82));

        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        setVisible(true);
    }
    
}
