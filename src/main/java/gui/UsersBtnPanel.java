package gui;

import gui.MainFrame;
import usecase.DiscoveryResponseModel;
import usecase.Presenter;

import javax.swing.*;
import java.awt.*;

/*
To display the 15 users found after discovery, each button links to user's personal info page
 */
public class UsersBtnPanel extends JPanel implements Presenter {
    public UsersBtnPanel(){
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.yellow);
    }

    @Override
    public void update(DiscoveryResponseModel dResponseModel) {
        Button btn1 = new Button(dResponseModel.getUserName1());
        btn1.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName1(), Color.CYAN));
        add(btn1.getButton());

        Button btn2 = new Button(dResponseModel.getUserName2());
        btn2.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName2(), Color.CYAN));
        add(btn2.getButton());

        Button btn3 = new Button(dResponseModel.getUserName3());
        btn3.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName3(), Color.CYAN));
        add(btn3.getButton());

        Button btn4 = new Button(dResponseModel.getUserName4());
        btn4.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName4(), Color.CYAN));
        add(btn4.getButton());

        Button btn5 = new Button(dResponseModel.getUserName5());
        btn5.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName5(), Color.CYAN));
        add(btn5.getButton());

        Button btn6 = new Button(dResponseModel.getUserName6());
        btn6.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName6(), Color.CYAN));
        add(btn6.getButton());

        Button btn7 = new Button(dResponseModel.getUserName7());
        btn7.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName7(), Color.CYAN));
        add(btn7.getButton());

        Button btn8 = new Button(dResponseModel.getUserName8());
        btn8.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName8(), Color.CYAN));
        add(btn8.getButton());

        Button btn9 = new Button(dResponseModel.getUserName9());
        btn9.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName9(), Color.CYAN));
        add(btn9.getButton());

        Button btn10 = new Button(dResponseModel.getUserName10());
        btn10.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName10(), Color.CYAN));
        add(btn10.getButton());

        Button btn11 = new Button(dResponseModel.getUserName11());
        btn11.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName11(), Color.CYAN));
        add(btn11.getButton());

        Button btn12 = new Button(dResponseModel.getUserName12());
        btn12.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName12(), Color.CYAN));
        add(btn12.getButton());

        Button btn13 = new Button(dResponseModel.getUserName13());
        btn13.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName13(), Color.CYAN));
        add(btn13.getButton());

        Button btn14 = new Button(dResponseModel.getUserName14());
        btn14.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName14(), Color.CYAN));
        add(btn14.getButton());

        Button btn15 = new Button(dResponseModel.getUserName15());
        btn15.getButton().addActionListener(new UserInfo(this, dResponseModel.getUserName15(), Color.CYAN));
        add(btn15.getButton());
    }
}