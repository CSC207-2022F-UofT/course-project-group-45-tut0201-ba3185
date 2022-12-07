package gui;
import controller.userController;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel(MainFrameInterface frame) {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the settings page."));

        JButton logoutButton = new JButton("Logout");
        this.add(logoutButton);

        logoutButton.addActionListener( ae -> {
            userController controller = new userController();
            controller.logoutUser();
            frame.switchToSignup();
        });
    }
}