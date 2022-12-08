package gui.chat;
import controller.FrontPageController;
import gui.MainFrame;
import presenter.FrontPagePresenter;
import use_case_frontpage.FrontPageInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPagePanel extends JPanel implements ActionListener {
    final int page_w = MainFrame.PAGE_WIDTH;
    final int page_h = MainFrame.PAGE_HEIGHT;
    FrontPageController controller;

    public FrontPagePanel() {
        FrontPagePresenter presenter = new FrontPagePresenter(this); //initialize panel, no input data
        FrontPageInteractor interactor = new FrontPageInteractor(presenter);
        this.controller = new FrontPageController(interactor);
    }

    public JScrollPane createFrontPageScreen() {
        //initialize our FrontPageScreen
        JLabel label = new JLabel("Bump Bump");
        label.setFont(new Font("Apple Chancery", Font.BOLD, 30));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(new Color(149, 74, 240));
        this.add(label);

        controller.create();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(page_w, (int) (page_h *0.9)); //(w = 414, h = 736*0.9)
        Color color = new Color(246, 186, 227);
        this.setBackground(color);

        JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // It's fine here for the variable to be redundant since it would too long if this is
        // combined in a sentence
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
    public void actionPerformed(ActionEvent e) {
        //when user clicked the User Button they want to chat with, a chatScreen is generated
        String targetUserId = ((JButton) e.getSource()).getText();
        ChatScreen c = new ChatScreen(targetUserId);
        c.create();
    }
}
