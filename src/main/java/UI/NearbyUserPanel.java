package UI;

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NearbyUserPanel extends JPanel implements ActionListener{

    private ArrayList<String> UserNameDistance;

    public NearbyUserPanel(ArrayList<String> UserNameDistance){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setMaximumSize( this.getPreferredSize() );
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

            }
        }
    }
}

