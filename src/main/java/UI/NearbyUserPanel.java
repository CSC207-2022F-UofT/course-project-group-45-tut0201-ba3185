package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NearbyUserPanel extends JPanel implements ActionListener{

    private ArrayList<String> UserNameDistance;

    public NearbyUserPanel(ArrayList<String> UserNameDistance){

        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the Nearby User page."));

        this.UserNameDistance = UserNameDistance;

    for(String u: UserNameDistance){
            JButton button = new JButton(u);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.addActionListener(this);
            button.setActionCommand(u);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        for(String u: UserNameDistance){
            if(action.equals(u)){
                //jump to user profile page
            }
        }
    }
}

