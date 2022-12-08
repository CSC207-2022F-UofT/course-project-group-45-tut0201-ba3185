package gui.chat;

import controller.BlockListController;
import controller.MessageController;
import entity.User;
import gui.MainFrame;
import presenter.MessagePresenter;
import use_case_blocklist.BlockListManager;
import use_case_message.MessageInteractor;
import use_case_message.MessageManagerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatScreen extends JFrame implements ActionListener,ChatScreenInterface{
    JButton sendButton;
    JButton blockButton;
    String messageValue; //get this from input Box
    String targetUserId; // get this from messageDisplayBox
    JTextField textField;
    MessageController controller;
    JPanel messageDisplayBox;
    final int page_w = MainFrame.PAGE_WIDTH;
    final int page_h = MainFrame.PAGE_HEIGHT;

    /**
     * Creates all UI components of ChatScreen UI
     */
    public ChatScreen(String targetUserId){
        this.targetUserId = targetUserId;
        this.sendButton = new JButton();
        this.blockButton = new JButton();
        this.textField = new JTextField();
        this.messageDisplayBox = new JPanel();

        MessageManagerFactory messageManagerFactory = new MessageManagerFactory();
        MessagePresenter messagePresenter = new MessagePresenter(this);
        MessageInteractor messageInteractor = new MessageInteractor(messagePresenter,
                messageManagerFactory);
        this.controller= new MessageController(messageInteractor);
    }

    public void create() {
        this.setSize(page_w, page_h);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setLocationRelativeTo(null);

        JPanel chatScreen = new JPanel();             //initialize our chatScreen
        chatScreen.setLayout(new BorderLayout());
        chatScreen.setPreferredSize(new Dimension(page_w, page_h * 9 / 10));
        Color c = new Color(255, 255, 255);
        chatScreen.setBackground(c);
        this.add(new JLabel("Chat with "+targetUserId));

             //the place it shows chatHistory
        messageDisplayBox.setBackground(new Color(246, 167, 232));
        messageDisplayBox.setPreferredSize(new Dimension(400, 300));
        messageDisplayBox.setLayout(new GridLayout(0, 1));

        controller.create(targetUserId);

        JScrollPane pane = new JScrollPane(messageDisplayBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setPreferredSize(new Dimension(400,300));
        chatScreen.add(pane, BorderLayout.NORTH);


         //user input area
        textField.setSize(400, 200);
        textField.setBackground(new Color(246, 200, 255));
        JScrollPane textPane = new JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textPane.setPreferredSize(new Dimension(400,200));
        chatScreen.add(textPane, BorderLayout.CENTER);

        JPanel southJPanel = new JPanel();
        chatScreen.add(southJPanel, BorderLayout.SOUTH);

        sendButton.setText("send");
        sendButton.addActionListener(this);
        sendButton.setBackground(new Color(218, 164, 202));
        sendButton.setPreferredSize(new Dimension(80, 50));
        southJPanel.add(sendButton, BorderLayout.NORTH);
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User(targetUserId, targetUserId, targetUserId);
        BlockListController controller = new BlockListController(blockListManager);
        if (0 != blockListManager.checkBlockList(buser)) {
            blockButton.setText("blocked");
        }else {
            blockButton.setText("block");
        }
        blockButton.addActionListener(e -> {
            if (0 != blockListManager.checkBlockList(buser)) {
                controller.removeBlockList(buser);
                blockButton.setText("block");
            }else {
                controller.addBlockList(buser);
                blockButton.setText("blocked");
            }
        });
        blockButton.setBackground(new Color(218, 164, 202));
        blockButton.setPreferredSize(new Dimension(80, 50));
        southJPanel.add(blockButton, BorderLayout.SOUTH);

        this.add(chatScreen);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User(targetUserId, targetUserId, targetUserId);
        int type = blockListManager.checkBlockList(buser);
        switch (type){
            case 0:
                messageValue = textField.getText();
                textField.setText(null);
                controller.create(targetUserId, messageValue);
                break;
            case 1:
                new screens.BlockDialog("This user is in your block list");
                break;
            case 2:
                new screens.BlockDialog("You are in their block list");
                break;
        }
    }

    public void loadChat(String msg){
        JLabel msgValue = new JLabel(msg, SwingConstants.LEFT);
        messageDisplayBox.add(msgValue);
        this.setVisible(true);
    }
}