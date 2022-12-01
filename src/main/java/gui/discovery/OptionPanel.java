package gui.discovery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class OptionPanel extends JPanel {
    private List<ActionListener> actionListeners;//users click three bottons
    public OptionPanel(){
        this.actionListeners = new ArrayList<>();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        //set buttons
        gui.discovery.Button preferenceBtn = new Button("By Preference");
        preferenceBtn.getButton().setActionCommand("preference");
        preferenceBtn.getButton().addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        //TODO: need to fetch with other two buttons
        gui.discovery.Button nearByBtn = new Button("By Near By");
        nearByBtn.getButton().setActionCommand("//");
        nearByBtn.getButton().addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });

        gui.discovery.Button searchBtn = new Button("By Search");
        searchBtn.getButton().setActionCommand("//");
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
