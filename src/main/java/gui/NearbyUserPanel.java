package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class NearbyUserPanel extends JPanel {

    private ArrayList<String> UserNameDistance;
    private List<ActionListener> actionListeners;

    public NearbyUserPanel(ArrayList<String> UserNameDistance){
        this.UserNameDistance = UserNameDistance;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the Nearby User page."));

        this.actionListeners = new ArrayList<>();
        for (String u: this.UserNameDistance){
            JButton UserButton = new JButton(u);
            UserButton.setOpaque(false);
            UserButton.setContentAreaFilled(false);
            UserButton.setFocusPainted(false);
            UserButton.setActionCommand("discoveryButton");
            UserButton.addActionListener(e -> {
                for(ActionListener listener: actionListeners){
                    listener.actionPerformed(e);
                }
            });
            this.add(UserButton);
        }
    }
}
