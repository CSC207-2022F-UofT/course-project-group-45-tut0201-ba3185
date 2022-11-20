package UI;

import Controller.LocationFinderController;
import gui.MainFrame;
import usecase.LocationFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NearbyUserPanel extends JPanel implements ActionListener{

    private ArrayList<String> UserNameDistance;
    private LocationFinderController controller;

    public NearbyUserPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setMaximumSize( this.getPreferredSize() );
        this.add(new TextField("This is the Nearby User page."));
        this.controller = LocationFinderController(LocationFinder);

        this.UserNameDistance =

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

