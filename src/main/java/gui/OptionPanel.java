package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This panel contains the option that user can choose from the three button and it will dispaly
 * the list based on the option chosen.
 */
public class OptionPanel extends JPanel {
    private List<ActionListener> actionListeners;//users click three bottons
    public OptionPanel(){
        this.actionListeners = new ArrayList<>();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        //set buttons
        Button preferenceBtn = new Button("By Preference");
        preferenceBtn.getButton().setActionCommand("preference");
        preferenceBtn.getButton().addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        //TODO: need to fetch with other two buttons
        Button nearByBtn = new Button("By Near");
        nearByBtn.getButton().setActionCommand("nearby");
        nearByBtn.getButton().addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });

        Button searchBtn = new Button("By Search");
        searchBtn.getButton().setActionCommand("search");
        searchBtn.getButton().addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });

        //layout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(preferenceBtn.getButton(),constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(searchBtn.getButton(),constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(nearByBtn.getButton(),constraints);

    }
    public void addActionListener(ActionListener a){
        if(!actionListeners.contains(a))
            actionListeners.add(a);
    }
}
