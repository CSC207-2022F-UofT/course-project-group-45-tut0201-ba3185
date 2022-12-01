package screens;

//import controller.StrengthCheckerUIControl;

import controller.MessageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatScreen extends JPanel implements ActionListener {
    JButton sendButton;
    String userid;
    String messageValue; //get this from input Box
    String targetUserId; // get this from messageDisplayBox
    //User user;
    JTextField textField;
    MessageController controller;
    MessageViewModel messageViewModel;
    JPanel messageDisplaybox;
    final int PAGE_W = 414;
    final int PAGE_H = 736;

    /**
     * Creates all UI components of ChatScreen UI
     */
    public ChatScreen(String targetUserId){
        this.controller = new MessageController();
        this.targetUserId = targetUserId;
        this.sendButton = new JButton();
        this.textField = new JTextField();
    }

    public JPanel create() {

        JPanel chatScreen = new JPanel();             //initialize our chatScreen
        chatScreen.setLayout(new BorderLayout());
        chatScreen.setPreferredSize(new Dimension(PAGE_W, PAGE_H * 9 / 10));
        Color c = new Color(255, 255, 255);
        chatScreen.setBackground(c);


        this.messageDisplaybox = new JPanel();      //the place it shows chatHistory
        messageDisplaybox.setBackground(new Color(246, 167, 232));
        messageDisplaybox.setPreferredSize(new Dimension(400, 300));
        messageDisplaybox.setLayout(new GridLayout(0, 1));

        //controller.create(userid, targetUserId);


        for (String i : messageViewModel.getMessages()){
            JLabel msgValue = new JLabel(i, SwingConstants.LEFT);
            messageDisplaybox.add(msgValue);
        }                                            //load chatHistory into messageDisplaybox

        JScrollPane pane = new JScrollPane(messageDisplaybox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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


        return chatScreen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        messageValue = textField.getText();


        //requestthis.controller.create(targetUserId, user, messageValue);

    }
}