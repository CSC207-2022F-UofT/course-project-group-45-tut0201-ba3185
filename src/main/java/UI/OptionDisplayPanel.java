package UI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptionDisplayPanel extends JPanel{

    private ArrayList<ActionListener> actionListeners;
    private ArrayList<String> questions;
    private String actionCommend;


    public OptionDisplayPanel(int width, int height){
        this.actionListeners = new ArrayList<>();
        this.setBounds(0,0, width, height);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel();
        label.setText("Choose one from below");
        label.setBounds((int) (width * 0.5), 0, 120, 20);
        this.add(label);

        Button btnP = new Button((int) (width*0.6), 125, 120, 60, "By Preference");
        btnP.setActionCommand("Preference");
        btnP.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(btnP);

        Button btnL = new Button((int) (width*0.6), 195, 120, 60, "By Location");
        btnL.setActionCommand("Location");
        btnL.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(btnL);

        Button btnS = new Button((int) (width*0.6), 265, 120, 60, "By Search");
        btnS.setActionCommand("Search");
        btnS.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(btnS);



    }

    public void addActionListener(ActionListener a){
        if(!actionListeners.contains(a))
            actionListeners.add(a);
    }
}
