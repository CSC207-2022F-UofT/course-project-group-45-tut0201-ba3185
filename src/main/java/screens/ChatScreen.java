package screens;

import controller.MessageController;
import gui.MainFrame;
import presenter.MessagePresenter;
import use_case_message.MessageInteractor;
import use_case_message.MessageManagerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatScreen extends JFrame implements ActionListener,ChatScreenInterface{
    JButton sendButton;
    String messageValue; //get this from input Box
    String targetUserId; // get this from messageDisplayBox
    JTextField textField;
    MessageController controller;
    JPanel messageDisplaybox;
    final int PAGE_W = 414;
    final int PAGE_H = 736;

    /**
     * Creates all UI components of ChatScreen UI
     */
    public ChatScreen(String targetUserId){
        this.targetUserId = targetUserId;
        this.sendButton = new JButton();
        this.textField = new JTextField();
        this.messageDisplaybox = new JPanel();

        MessageManagerFactory messageManagerFactory = new MessageManagerFactory();
        MessagePresenter messagePresenter = new MessagePresenter(this);
        MessageInteractor messageInteractor = new MessageInteractor(messagePresenter,
                messageManagerFactory, MainFrame.messageManagers);
        this.controller= new MessageController(messageInteractor);
    }

    public void create() {
        this.setSize(PAGE_W, PAGE_H);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setLocationRelativeTo(null);

        JPanel chatScreen = new JPanel();             //initialize our chatScreen
        chatScreen.setLayout(new BorderLayout());
        chatScreen.setPreferredSize(new Dimension(PAGE_W, PAGE_H * 9 / 10));
        Color c = new Color(255, 255, 255);
        chatScreen.setBackground(c);
        this.add(new JLabel("Chat with "+targetUserId));

             //the place it shows chatHistory
        messageDisplaybox.setBackground(new Color(246, 167, 232));
        messageDisplaybox.setPreferredSize(new Dimension(400, 300));
        messageDisplaybox.setLayout(new GridLayout(0, 1));

        controller.create(targetUserId);

        JScrollPane pane = new JScrollPane(messageDisplaybox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setPreferredSize(new Dimension(400,300));
        chatScreen.add(pane, BorderLayout.NORTH);


         //user input area
        textField.setSize(400, 200);
        textField.setBackground(new Color(246, 200, 255));
        JScrollPane textPane = new JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textPane.setPreferredSize(new Dimension(400,200));
        chatScreen.add(textPane, BorderLayout.CENTER);


        sendButton.setText("send");
        sendButton.addActionListener(this);
        sendButton.setBackground(new Color(218, 164, 202));
        sendButton.setPreferredSize(new Dimension(80, 50));
        chatScreen.add(sendButton, BorderLayout.SOUTH);

        this.add(chatScreen);
        this.setVisible(true);


        //return this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        messageValue = textField.getText();
        textField.setText(null);
        controller.create(targetUserId, messageValue);
    }

    public void loadChat(String msg){
        JLabel msgValue = new JLabel(msg, SwingConstants.LEFT);
        messageDisplaybox.add(msgValue);
        this.setVisible(true);
    }
}