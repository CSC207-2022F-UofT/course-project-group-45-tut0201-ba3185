package UI.CamillaPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecommendUserPanel extends JPanel {
    private List<ActionListener> actionListeners;
    private ArrayList<String> userNames;
    // in the main discovery page, once the preference button clicked, it calls
    //controller, usecase, presenter, get the usernames(15 String) and create a
    //new panel to display these, each with one button of username
    public RecommendUserPanel(ArrayList<String> userNames) {
        this.userNames = userNames;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the Recommended User page."));

        this.actionListeners = new ArrayList<>();
        for (String userName:this.userNames){
            Button tempBtn = new Button(userName);
            tempBtn.getButton().addActionListener(e -> {
                for(ActionListener listener: actionListeners){
                    listener.actionPerformed(e);
                }
            });
            this.add(tempBtn.getButton());
        }

    }


}
