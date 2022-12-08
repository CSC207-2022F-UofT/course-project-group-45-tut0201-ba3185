package gui.discovery;

import gui.MainFrame;
import use_case_discovery.UserInfoInterface;
import use_case_discovery.UserInfoResponseModel;

import javax.swing.*;
import java.awt.*;


public class PersonalInfoPanel extends JPanel implements UserInfoInterface {

    public PersonalInfoPanel(){
        //this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.CYAN);
    }


    @Override
    public void update(UserInfoResponseModel dModel) {
        JLabel name= new JLabel(dModel.getName());
        this.add(name);
        JLabel age= new JLabel(String.valueOf(dModel.getAge()));
        this.add(age);
        JLabel hobby= new JLabel(dModel.getHobby());
        this.add(hobby);
        JLabel relationship= new JLabel(dModel.getRelationshipType());
        this.add(relationship);

    }
}
