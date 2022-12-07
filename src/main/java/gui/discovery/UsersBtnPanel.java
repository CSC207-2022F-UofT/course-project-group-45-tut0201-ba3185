package gui.discovery;

import gui.MainFrame;
import gui.discovery.Button;
import gui.discovery.UserInfo;
import use_case_discovery.DiscoveryListInterface;
import use_case_discovery.DiscoveryResponseModel;


import javax.swing.*;
import java.awt.*;

/**
 * Displays the 15 users found after discovery, each button links to user's personal info page
 */
public class UsersBtnPanel extends JPanel implements DiscoveryListInterface {

    public UsersBtnPanel(){
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.yellow);
    }

    @Override
    public void update(DiscoveryResponseModel dResponseModel) {
        gui.discovery.Button btn1 = new gui.discovery.Button(dResponseModel.getUserName1());
        btn1.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName1()));
        add(btn1.getButton());

        gui.discovery.Button btn2 = new gui.discovery.Button(dResponseModel.getUserName2());
        btn2.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName2()));
        add(btn2.getButton());

        gui.discovery.Button btn3 = new gui.discovery.Button(dResponseModel.getUserName3());
        btn3.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName3()));
        add(btn3.getButton());

        gui.discovery.Button btn4 = new gui.discovery.Button(dResponseModel.getUserName4());
        btn4.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName4()));
        add(btn4.getButton());

        gui.discovery.Button btn5 = new gui.discovery.Button(dResponseModel.getUserName5());
        btn5.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName5()));
        add(btn5.getButton());

        gui.discovery.Button btn6 = new gui.discovery.Button(dResponseModel.getUserName6());
        btn6.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName6()));
        add(btn6.getButton());

        gui.discovery.Button btn7 = new gui.discovery.Button(dResponseModel.getUserName7());
        btn7.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName7()));
        add(btn7.getButton());

        gui.discovery.Button btn8 = new gui.discovery.Button(dResponseModel.getUserName8());
        btn8.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName8()));
        add(btn8.getButton());

        gui.discovery.Button btn9 = new gui.discovery.Button(dResponseModel.getUserName9());
        btn9.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName9()));
        add(btn9.getButton());

        gui.discovery.Button btn10 = new gui.discovery.Button(dResponseModel.getUserName10());
        btn10.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName10()));
        add(btn10.getButton());

        gui.discovery.Button btn11 = new gui.discovery.Button(dResponseModel.getUserName11());
        btn11.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName11()));
        add(btn11.getButton());

        gui.discovery.Button btn12 = new gui.discovery.Button(dResponseModel.getUserName12());
        btn12.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName12()));
        add(btn12.getButton());

        gui.discovery.Button btn13 = new gui.discovery.Button(dResponseModel.getUserName13());
        btn13.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName13()));
        add(btn13.getButton());

        gui.discovery.Button btn14 = new gui.discovery.Button(dResponseModel.getUserName14());
        btn14.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName14()));
        add(btn14.getButton());

        gui.discovery.Button btn15 = new Button(dResponseModel.getUserName15());
        btn15.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName15()));
        add(btn15.getButton());
    }
}