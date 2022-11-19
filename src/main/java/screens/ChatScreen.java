package screens;

//import controller.StrengthCheckerUIControl;

import use_case_message.MessageOutputBoundary;
import use_case_message.MessageViewModel;

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
    public ChatScreen(int page_h, int page_w, MessageController controller, MessageViewModel messageViewModel) {

        int screen_h = page_h * 9 / 10; //the screen is 90% of our page size. quote from Eric.

        JPanel textFieldBox = new JPanel();
        JPanel buttonbox = new JPanel();

        JPanel chatScreen = new JPanel();//initialize our chatScreen
        chatScreen.setPreferredSize(new Dimension(page_w, screen_h)); //(w = 414, h = 736*0.9)
        SpringLayout layout = new SpringLayout();
        chatScreen.setLayout(layout);
        Color c = new Color(204, 255, 255);
        chatScreen.setBackground(c);


        int display_h = screen_h / 2;
        JPanel messageDisplayBox = new JPanel();
        //messageDisplayBox.setBounds(page_w / 10, page_w / 10, page_w - 80, display_h);// the place we can see our chat messages
        Color m = new Color(0, 255, 255);
        messageDisplayBox.setBackground(m);

        for (String i :messageViewModel.getMessages()){
            JLabel msgvalue = new JLabel();
            msgvalue.setFont(new Font("Serif", Font.PLAIN, 14));
        }





        JTextField textField = new JTextField(); //user input area
        textField.setBounds(page_w / 10, screen_h / 2 + 80, page_w - 80, display_h); //textfeild for input message
        Color t = new Color(0, 200, 255);
        textField.setBackground(t);
        textFieldBox.add(textField);


        JScrollPane scrollbar = new JScrollPane(textField);
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollbar.setSize(40, 60);

        JLabel label = new JLabel("enter message here:");
        int label_x = 0;
        int label_Width = page_w * 8 / 10;
        int label_Height = screen_h / 10;
        label.setBounds(label_x, screen_h / 2, label_Width, label_Height);
        label.setLabelFor(textField);


        int bound_x = 140;
        int bound_y = 600;
        int bound_width = 60;
        int bound_height = 30;
        sendButton = new JButton();
        sendButton.setBounds(bound_x, bound_y, bound_width, bound_height);
        sendButton.setText("send");
        sendButton.addActionListener(this);
        buttonbox.add(sendButton);

        layout.putConstraint(SpringLayout.NORTH, messageDisplayBox, 40, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, messageDisplayBox, 40, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, messageDisplayBox, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, messageDisplayBox, display_h-340, SpringLayout.SOUTH, this);

        layout.putConstraint(SpringLayout.NORTH, textFieldBox, 176, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, textFieldBox, 40, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, textFieldBox, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, textFieldBox, 40, SpringLayout.SOUTH, this);

        layout.putConstraint(SpringLayout.NORTH,  buttonbox, 176, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, buttonbox, 40, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, buttonbox, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, buttonbox, 40, SpringLayout.SOUTH, this);

        chatScreen.add(buttonbox);
        chatScreen.add(textFieldBox);
        chatScreen.add(messageDisplayBox);


        this.add(chatScreen);

    }
}