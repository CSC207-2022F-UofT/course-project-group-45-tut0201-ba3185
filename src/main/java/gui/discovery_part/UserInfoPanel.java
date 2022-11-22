package gui.discovery_part;

import javax.swing.*;
import java.awt.*;
/*
This panel is intended to display user's info with chat button and block button
so far the panel only display two buttons
//TODO: fetch with user to update user info on panel
 */
public class UserInfoPanel extends JPanel {
    public UserInfoPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Color.white);
        constraints.insets = new Insets(10,10,10,10);
        constraints.gridx = 2;
        constraints.gridy = 1;
        this.add(new JButton("Chat"),constraints);
        constraints.gridx = 2;
        constraints.gridy = 2;
        this.add(new JButton("Block"), constraints);







    }


}
