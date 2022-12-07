package gui.discovery;

import gui.MainFrame;
import use_case_discovery.DiscoveryResponseModel;
import use_case_discovery.DiscoveryListInterface;

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
        Button btn1 = new Button(dResponseModel.getUserName1());
        btn1.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName1()));
        add(btn1.getButton());

        Button btn2 = new Button(dResponseModel.getUserName2());
        btn2.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName2()));
        add(btn2.getButton());

        Button btn3 = new Button(dResponseModel.getUserName3());
        btn3.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName3()));
        add(btn3.getButton());

        Button btn4 = new Button(dResponseModel.getUserName4());
        btn4.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName4()));
        add(btn4.getButton());

        Button btn5 = new Button(dResponseModel.getUserName5());
        btn5.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName5()));
        add(btn5.getButton());

        Button btn6 = new Button(dResponseModel.getUserName6());
        btn6.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName6()));
        add(btn6.getButton());

        Button btn7 = new Button(dResponseModel.getUserName7());
        btn7.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName7()));
        add(btn7.getButton());

        Button btn8 = new Button(dResponseModel.getUserName8());
        btn8.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName8()));
        add(btn8.getButton());

        Button btn9 = new Button(dResponseModel.getUserName9());
        btn9.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName9()));
        add(btn9.getButton());

        Button btn10 = new Button(dResponseModel.getUserName10());
        btn10.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName10()));
        add(btn10.getButton());

        Button btn11 = new Button(dResponseModel.getUserName11());
        btn11.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName11()));
        add(btn11.getButton());

        Button btn12 = new Button(dResponseModel.getUserName12());
        btn12.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName12()));
        add(btn12.getButton());

        Button btn13 = new Button(dResponseModel.getUserName13());
        btn13.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName13()));
        add(btn13.getButton());

        Button btn14 = new Button(dResponseModel.getUserName14());
        btn14.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName14()));
        add(btn14.getButton());

        Button btn15 = new Button(dResponseModel.getUserName15());
        btn15.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName15()));
        add(btn15.getButton());
    }
}
