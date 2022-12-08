package gui;
import controller.FrontPageController;
import presenter.FrontPagePresenter;
import screens.ChatScreen;
import use_case_frontpage.FrontPageInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPagePanel extends JPanel implements ActionListener {
    final int PAGE_W = 414;
    final int PAGE_H = 736;
    FrontPageController controller;

    public FrontPagePanel() {
        FrontPagePresenter presenter = new FrontPagePresenter(this); //initialize panel, no input data
        FrontPageInteractor interactor = new FrontPageInteractor(presenter);
        this.controller = new FrontPageController(interactor);
    }

    public JScrollPane createFrontPageScreen() {
        //initialize our FrontPageScreen
        controller.create("Sunny");
        controller.create("Alyssa");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(PAGE_W, (int) (PAGE_H*0.9)); //(w = 414, h = 736*0.9)
        Color color = new Color(246, 186, 227);
        this.setBackground(color);

        JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setSize(page_w, screen_h);


        return scrollPane;
    }

    public void loadUser(String username){
        JButton button = new JButton();
        button.setText(username);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   //when user clicked the userbutton they want to chat with, a chatScreen is generated
        String targetUserId = ((JButton) e.getSource()).getText();
        ChatScreen c = new ChatScreen(targetUserId);
        c.create();
    }
}
