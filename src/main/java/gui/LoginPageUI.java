package gui;

import controller.SigninPageController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static javax.swing.SpringLayout.*;

public class LoginPageUI extends JPanel {
    public static final int PAGE_HEIGHT = 736;
    public static final int PAGE_WIDTH = 414;
    public LoginPageUI(MainFrameInterface frame) {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);

        JPanel parentPanel = new JPanel(new SpringLayout());
        parentPanel.setPreferredSize(new Dimension(PAGE_WIDTH,PAGE_HEIGHT));
        SpringLayout parentLayout = (SpringLayout) parentPanel.getLayout();

        // add textFields
        JLabel username = new JLabel("Username:", JLabel.TRAILING);
        JTextField usernameTextField = new JTextField(10);
        usernameTextField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        username.setLabelFor(usernameTextField);

        JLabel password = new JLabel("Password:", JLabel.TRAILING);
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        password.setLabelFor(passwordField);

        // Populate the fieldPanel
        JPanel fieldPanel = new JPanel(new SpringLayout());
        fieldPanel.setPreferredSize(new Dimension(PAGE_WIDTH/2,PAGE_HEIGHT/5));

        fieldPanel.add(usernameTextField);
        fieldPanel.add(passwordField);
        fieldPanel.add(username);
        fieldPanel.add(password);

        // fieldPanel Layout
        SpringLayout fieldLayout = (SpringLayout) fieldPanel.getLayout();

        fieldLayout.putConstraint(WEST, username, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(WEST, password, 0, WEST, fieldPanel);

        // distance between Label
        fieldLayout.putConstraint(NORTH, username, 6, NORTH, fieldPanel);
        fieldLayout.putConstraint(NORTH, password, 30, SOUTH, username);

        // Put Field to the East wall
        fieldLayout.putConstraint(EAST, usernameTextField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, passwordField,0 ,EAST, fieldPanel);

        // Label and Field on same horizontal
        fieldLayout.putConstraint(NORTH, usernameTextField, 0, NORTH, fieldPanel);
        fieldLayout.putConstraint(NORTH, passwordField, 20, SOUTH, usernameTextField);

        // Creating TextPanel
        JPanel textPanel = new JPanel(new SpringLayout());
        textPanel.setPreferredSize(new Dimension(PAGE_WIDTH,100));
        SpringLayout textLayout = (SpringLayout) textPanel.getLayout();

        // Creating text and populating textPanel
        JLabel Title = new JLabel("Login to your Account!");
        Title.setFont(new Font("Helvetica", Font.BOLD , 28));
        textPanel.add(Title);

        // Layout for textPanel
        textLayout.putConstraint(HORIZONTAL_CENTER, Title, 0, HORIZONTAL_CENTER, textPanel);

        // Creat buttonPanel
        JPanel buttonPanel = new JPanel(new SpringLayout());
        SpringLayout buttonLayout = (SpringLayout) buttonPanel.getLayout();
        buttonPanel.setPreferredSize(new Dimension(PAGE_WIDTH, 200));

        // Creating the Buttons
        JButton LoginButton = new JButton("Login");
        JButton switchView = new JButton("Signup");
        LoginButton.setPreferredSize(new Dimension(PAGE_WIDTH/2,40));
        LoginButton.setForeground(new Color(144, 238, 144));
        switchView.setPreferredSize(new Dimension(PAGE_WIDTH/2, 40));
        buttonPanel.add(LoginButton);
        buttonPanel.add(switchView);

        // Layout for Button Panel
        buttonLayout.putConstraint(HORIZONTAL_CENTER, LoginButton, 0, HORIZONTAL_CENTER, buttonPanel);
        buttonLayout.putConstraint(NORTH, switchView, 20, SOUTH, LoginButton);
        buttonLayout.putConstraint(HORIZONTAL_CENTER, switchView, 0, HORIZONTAL_CENTER, buttonPanel);

        // Parent Panel Layout
        parentLayout.putConstraint(SOUTH, buttonPanel, 0, SOUTH, this);
        parentLayout.putConstraint(HORIZONTAL_CENTER, fieldPanel, 0, HORIZONTAL_CENTER, this);
        parentLayout.putConstraint(NORTH, (Component) fieldPanel, (int) (PAGE_HEIGHT/2.5), NORTH, this);
        parentLayout.putConstraint(NORTH, textPanel, 80, NORTH, this);

        parentPanel.add(fieldPanel);
        parentPanel.add(buttonPanel);
        parentPanel.add(textPanel);

        switchView.addActionListener( ae -> {
            frame.switchToSignup();
        });

        LoginButton.addActionListener( ae -> {
            String currentUsername = usernameTextField.getText();
            String currentPassword = String.valueOf(passwordField.getPassword());

            try {
                SigninPageController controller = new SigninPageController();
                Boolean isUserReal = controller.userExist(currentUsername);
                Boolean checkPassword = controller.matchingPassword(currentUsername, currentPassword);
                if(isUserReal && checkPassword) {
                    controller.setCurrentUser(currentUsername);
                    frame.switchToMain();

                }
                else {
                    if(!isUserReal) {
                        JOptionPane.showMessageDialog(null, "This user does not exist");
                    }
                    else if(!checkPassword) {
                        JOptionPane.showMessageDialog(null, "Wrong password for this user.");
                    }

                }
            }
            catch(IOException exception) {
                throw new RuntimeException(exception);
            }
        });

        this.add(parentPanel);
    }
}
