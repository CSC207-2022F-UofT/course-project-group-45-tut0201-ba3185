package gui.discovery_part;

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
To generate user info panel with given username by using nested class
to generate the panel to add on
 */
public class UserInfo implements ActionListener {
    JPanel panelToAddOn;
    String pName;
    Color color;

    /**
     *
     * @param panel the panel that userInfo panel is added on
     * @param pName the name of user
     * @param color the color of added panel
     */

    public UserInfo(JPanel panel, String pName, Color color){
        this.panelToAddOn = panel;
        this.pName = pName;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel infoP = new UserInfoPanel(this.color, this.pName);
        this.panelToAddOn.add(infoP);
        this.panelToAddOn.revalidate();
    }
    private static class UserInfoPanel extends JPanel{
        String pName;
        Color color;
        public UserInfoPanel(Color color, String pName){
            this.pName = pName;
            this.color = color;
            this.add(new JLabel("This is the info page of " + this.pName));
            this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 8));
            this.setLayout(null);
            this.setLayout(new FlowLayout(FlowLayout.TRAILING));
            this.setBackground(this.color);
            JButton chat = new JButton("Chat");
            JButton block = new JButton("Block");
            this.add(chat);
            this.add(block);
            this.revalidate();
        }
    }
}
