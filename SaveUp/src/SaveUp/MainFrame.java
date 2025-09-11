package SaveUp;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void mainFrame() {

        setTitle("SaveUp Pocket"); // Sets the title to SaveUp Pocket
        setSize(1080, 720); // Sets the initial size of the application
        setDefaultCloseOperation(EXIT_ON_CLOSE); // The application ends when the GUI gets closed 
        setLayout(new BorderLayout());

        setExtendedState(MAXIMIZED_BOTH); //Automatically full screens the window of the application once it is started
        setLocationRelativeTo(null); //Centers the window after opening the application on full screen

        ImageIcon rawAppIcon = new ImageIcon(getClass().getResource("/SaveUp/AppIcon.png")); //imports the same image but for the purpose of the application icon
        Image appIcon = rawAppIcon.getImage().getScaledInstance(4096, 4096, Image.SCALE_AREA_AVERAGING);
        setIconImage(appIcon);
    


        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/SaveUp/AppIcon.png")); //imports an image from the same file folder
        Image scaledImage = rawIcon.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT); //sets the new size of the image
        ImageIcon scaledIcon = new ImageIcon(scaledImage); 

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(61, 61, 61));

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(scaledIcon); //Uses the logo itself for the logo pannel
        logoLabel.setText("SaveUp Pocket");
        logoLabel.setForeground(new Color(255, 255, 255));
        add(logoLabel);

        getContentPane().setBackground(new Color(82, 82, 82));

        logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoLabel.setHorizontalTextPosition(JLabel.CENTER);

        logoLabel.setVerticalAlignment(JLabel.TOP);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(new Color(82, 82, 82));
        setLayout(new FlowLayout());

        JPanel sidepanelR = new JPanel();
        sidepanelR.setBackground(new Color(61, 61, 61));

        JPanel sidepanelL = new JPanel();
        sidepanelL.setBackground(new Color(61, 61, 61));;

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(61, 61, 61));

        JButton newPocket = new JButton("Create New Pocket");
        newPocket.addActionListener(e -> Transactions.showRegister());

        JButton peekPocket = new JButton("Peek a Pocket :)");
        newPocket.addActionListener(e -> Transactions.showLogIn());

        actionPanel.add(Box.createVerticalGlue());
        actionPanel.add(newPocket);
        actionPanel.add(Box.createVerticalStrut(20));
        actionPanel.add(peekPocket);
        actionPanel.add(Box.createVerticalGlue());



        add(logoPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.CENTER);
        add(sidepanelL, BorderLayout.EAST);
        add(sidepanelR, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
        logoPanel.add(logoLabel);
        setVisible(true);
    }
    
}
