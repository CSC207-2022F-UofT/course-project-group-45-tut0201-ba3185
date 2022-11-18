package screens;

//import controller.StrengthCheckerUIControl;

import use_case_chat.ChatInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatScreen extends JPanel implements ActionListener{
    Button sendButton;
    String messageValue;
    String targetUserId;// get this from
    MessageController controller;

    /**
     * Creates all UI components of StrengthCheckerBox UI
     */
    public ChatScreen(int page_h, int page_w, MessageController controller, ChatOutputBoundary chatOutputBoundary)  {

        this.controller = controller;

        int screen_h = page_h * 9/10; //the screen is 90% of our page size. quote from Eric.


        JPanel chatScreen = new JPanel();//initialize our chatScreen
        chatScreen.setSize(page_w, screen_h); //(w = 414, h = 736*0.9)


        int display_h = screen_h /2;
        JPanel messageDisplayBox = new JPanel();
        messageDisplayBox.setBounds(0, 0, display_h, page_w);// the place we can see our chat messages
        //messageDisplayBox.add(chatOutputBoundary.generateResponseMsg()) 问一下Jennifer

        JTextField textField = new JTextField();
        int boundx = 2;
        int boundy = 420;
        int textFieldWidth = 409;
        int textFieldHeight = 200;
        textField.setBounds(boundx, boundy, textFieldWidth, textFieldHeight); //textfeild for input message
        JScrollPane scrollbar = new JScrollPane(textField);


        JLabel label = new JLabel("enter message here:");
        int label_x = 0;
        int label_Width = page_w * 8/10;
        int label_Height = screen_h /10;
        label.setBounds(label_x,screen_h /2,label_Width,label_Height);

        int bound_x = 130;
        int bound_y = 600;
        int bound_width = 60;
        int bound_height = 30;
        sendButton = new Button();
        sendButton.createButtonWithText("send", bound_x, bound_y, bound_width, bound_height);

        chatScreen.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //use boxlayout in our chatScreen
        Color c = new Color(204,255,255);
        chatScreen.setBackground(c);

        chatScreen.add(messageDisplayBox);
        chatScreen.add(textField);
        chatScreen.add(scrollbar);
        chatScreen.add(sendButton.getButton());
        chatScreen.setVisible(true);

        sendButton.getButton().addActionListener(this);// Each time we click button, we pass msg value to controller

        messageValue = textField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.createRM(targetUserId, messageValue);

        try {
            controller.create(, messageValue);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}