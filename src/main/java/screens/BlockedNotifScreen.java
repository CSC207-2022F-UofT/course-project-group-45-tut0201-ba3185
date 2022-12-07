package screens;

import controller.MessageController;
import gui.MainFrame;
import presenter.MessagePresenter;
import use_case_message.MessageInteractor;
import use_case_message.MessageManagerFactory;

import javax.swing.*;

public class BlockedNotifScreen extends JFrame{
    JButton confirmButton;

    final int page_w = 400;
    final int page_h = 300;

    /**
     * Creates all UI components of ChatScreen UI
     */
    public BlockedNotifScreen(String targetUserId){
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setFont(new java.awt.Font("Times New Roman", 1, 18));
        label.setText("You are blocked by the current user, message can't be sent!");
        panel.add(label);
    }
}
