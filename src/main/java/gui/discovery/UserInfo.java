package gui.discovery;

import controller.UserInfoController;
import gui.MainFrame;
import use_case_discovery.UserInfoInputBoundary;
import use_case_discovery.UserInfoInteractor;
import use_case_discovery.UserInfoInterface;
import use_case_discovery.UserInfoResponseModel;

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
        JPanel infoP = new UserInfoPanel(this.pName);
        this.panelToAddOn.add(infoP);
        this.panelToAddOn.revalidate();
    }
    private static class UserInfoPanel extends JPanel {
        String pName;
        public UserInfoPanel(String pName){
            this.pName = pName;
            this.add(new JLabel("This is the info page of " + this.pName));
            this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 8));
            this.setLayout(null);
            this.setLayout(new FlowLayout(FlowLayout.TRAILING));
            this.setBackground(Color.CYAN);
            JButton chat = new JButton("Chat");


            UserInfoInterface personalInfo = new PersonalInfoPanel();
            UserInfoInputBoundary interactor = new UserInfoInteractor(personalInfo);
            UserInfoController controller = new UserInfoController(this.pName,interactor);
            controller.findInfo();


            this.add(chat);
            this.add((Component) personalInfo);
            this.revalidate();
        }
    }
}
