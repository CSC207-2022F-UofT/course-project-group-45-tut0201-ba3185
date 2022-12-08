package gui.discovery;

import controller.UserInfoController;
import gui.MainFrame;
import use_case_discovery.UserInfoInputBoundary;
import use_case_discovery.UserInfoInteractor;
import use_case_discovery.UserInfoInterface;
import use_case_discovery.UserInfoResponseModel;
import gui.chat.ChatScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Generates user info panel with given username by using nested class to generate the panel to add on
 * A Chat button is added to link with the chat feature
 */
public class UserInfo implements ActionListener {
    JPanel panelToAddOn;
    String pName;

    /**
     *
     * @param panel the panel that userInfo panel is added on
     * @param pName the name of user
     */

    public UserInfo(JPanel panel, String pName){
        this.panelToAddOn = panel;
        this.pName = pName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserInfoInterface personalInfo = new UserInfoPanel(this.pName);
        UserInfoInputBoundary interactor = new UserInfoInteractor(personalInfo);
        UserInfoController controller = new UserInfoController(this.pName,interactor);
        controller.findInfo();

        this.panelToAddOn.add((JPanel)personalInfo);
        this.panelToAddOn.revalidate();
    }
    private static class UserInfoPanel extends JPanel implements UserInfoInterface {
        String pName;
        public UserInfoPanel(String pName){
            this.pName = pName;
            this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 8));
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setBackground(Color.CYAN);
            this.revalidate();
        }

        @Override
        public void update(UserInfoResponseModel dModel) {

            this.add(new JLabel("This is the info page of " + this.pName));
            JButton chat = new JButton("Chat");
            chat.addActionListener(e -> {
                ChatScreen c = new ChatScreen(this.pName);
                c.create();
            });
            this.add(chat);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel name =new JLabel("Name: " + dModel.getName());
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            this.add(new JLabel("Age: " + dModel.getAge()));
            this.add(new JLabel("Hobby:" + dModel.getHobby()));
            this.add(new JLabel("I want the relationship be like " + dModel.getRelationshipType()));
        }
    }
}