package gui;

import com.sun.tools.javac.Main;
import controller.SignupPageController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static javax.swing.SpringLayout.*;

public class SignupPageUI extends JPanel {

    private static final int PAGE_WIDTH = MainFrame.PAGE_WIDTH;
    private static final int PAGE_HEIGHT = MainFrame.PAGE_HEIGHT;

    public SignupPageUI(MainFrameInterface frame) {

        // Setup basic Frame structure
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        JPanel parentPanel = new JPanel(new SpringLayout());
        parentPanel.setPreferredSize(new Dimension(PAGE_WIDTH,PAGE_HEIGHT));
        SpringLayout parentLayout = (SpringLayout) parentPanel.getLayout();

        // add textFields
        JLabel username = new JLabel("Username:", JLabel.TRAILING);
        JTextField usernameTextField = new JTextField(10);
        usernameTextField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        username.setLabelFor(usernameTextField);

        JLabel name = new JLabel("Name:", JLabel.TRAILING);
        JTextField nameTextField = new JTextField(10);
        nameTextField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        name.setLabelFor(nameTextField);

        JLabel password = new JLabel("Password:", JLabel.TRAILING);
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        password.setLabelFor(passwordField);

        JLabel passwordConfirm = new JLabel("Confirm Password:", JLabel.TRAILING);
        JPasswordField confirmPasswordField = new JPasswordField(10);
        confirmPasswordField.setMaximumSize(new Dimension(PAGE_WIDTH-20, 20));
        passwordConfirm.setLabelFor(confirmPasswordField);

        // Populate the fieldPanel
        JPanel fieldPanel = new JPanel(new SpringLayout());
        fieldPanel.setPreferredSize(new Dimension((int) (PAGE_WIDTH/1.6),PAGE_HEIGHT/3));

        fieldPanel.add(usernameTextField);
        fieldPanel.add(nameTextField);
        fieldPanel.add(passwordField);
        fieldPanel.add(username);
        fieldPanel.add(name);
        fieldPanel.add(password);
        fieldPanel.add(confirmPasswordField);
        fieldPanel.add(passwordConfirm);

        // fieldPanel Layout
        SpringLayout fieldLayout = (SpringLayout) fieldPanel.getLayout();

        fieldLayout.putConstraint(WEST, name, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(WEST, username, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(WEST, password, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(NORTH, name, 10, NORTH, fieldPanel);
        fieldLayout.putConstraint(WEST, passwordConfirm, 0, WEST, fieldPanel);

        // distance between Label
        fieldLayout.putConstraint(NORTH, username, 30, SOUTH, name);
        fieldLayout.putConstraint(NORTH, password, 30, SOUTH, username);
        fieldLayout.putConstraint(NORTH, passwordConfirm, 30, SOUTH, password);

        // Put Field to the East wall
        fieldLayout.putConstraint(EAST, nameTextField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, usernameTextField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, passwordField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, confirmPasswordField, 0 ,EAST, fieldPanel);

        // Label and Field on same horizontal
        fieldLayout.putConstraint(NORTH,nameTextField, 7, NORTH, fieldPanel);
        fieldLayout.putConstraint(NORTH, usernameTextField, 20, SOUTH, nameTextField);
        fieldLayout.putConstraint(NORTH, passwordField, 20, SOUTH, usernameTextField);
        fieldLayout.putConstraint(NORTH, confirmPasswordField, 20, SOUTH, passwordField);

        // Creating TextPanel
        JPanel textPanel = new JPanel(new SpringLayout());
        textPanel.setPreferredSize(new Dimension(PAGE_WIDTH,100));
        SpringLayout textLayout = (SpringLayout) textPanel.getLayout();

        // Creating text and populating textPanel
        JLabel Title = new JLabel("Sign up!");
        Title.setFont(new Font("Helvetica", Font.BOLD , 28));
        textPanel.add(Title);

        // Layout for textPanel
        textLayout.putConstraint(HORIZONTAL_CENTER, Title, 0, HORIZONTAL_CENTER, textPanel);

        // Creat buttonPanel
        JPanel buttonPanel = new JPanel(new SpringLayout());
        SpringLayout buttonLayout = (SpringLayout) buttonPanel.getLayout();
        buttonPanel.setPreferredSize(new Dimension(PAGE_WIDTH, 200));

        // Creating the Buttons
        JButton SignupButton = new JButton("Signup");
        JButton switchView = new JButton("Login");
        SignupButton.setPreferredSize(new Dimension(PAGE_WIDTH/2,40));
        SignupButton.setForeground(new Color(144, 238, 144));
        switchView.setPreferredSize(new Dimension(PAGE_WIDTH/2, 40));
        buttonPanel.add(SignupButton);
        buttonPanel.add(switchView);

        // Layout for Button Panel
        buttonLayout.putConstraint(HORIZONTAL_CENTER, SignupButton, 0, HORIZONTAL_CENTER, buttonPanel);
        buttonLayout.putConstraint(NORTH, switchView, 20, SOUTH, SignupButton);
        buttonLayout.putConstraint(HORIZONTAL_CENTER, switchView, 0, HORIZONTAL_CENTER, buttonPanel);

        // Parent Panel Layout
        parentLayout.putConstraint(SOUTH, buttonPanel, 0, SOUTH, this);
        parentLayout.putConstraint(HORIZONTAL_CENTER, fieldPanel, 0, HORIZONTAL_CENTER, this);
        parentLayout.putConstraint(NORTH, fieldPanel, PAGE_HEIGHT/3, NORTH, this);
        parentLayout.putConstraint(NORTH, textPanel, 80, NORTH, this);

        parentPanel.add(fieldPanel);
        parentPanel.add(buttonPanel);
        parentPanel.add(textPanel);

        // Switches the view when User presses on login
        switchView.addActionListener( ae -> {
            frame.switchToLogin();
        });

        SignupButton.addActionListener( ae -> {
            String currentUsername = usernameTextField.getText();
            String currentName = nameTextField.getText();
            String currentPassword = String.valueOf(passwordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
            if(!currentName.equals("") && !currentUsername.equals("") && !currentPassword.equals("") &&
                    !confirmPassword.equals("")) {
                if(confirmPassword.equals(currentPassword)) {
                    try {
                        Boolean isUserTaken = new SignupPageController().userExist(currentUsername);

                        if(!isUserTaken) {
                            frame.switchToInitSetup(currentUsername,currentName,currentPassword);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "This username is already taken");
                        }
                    }
                    catch (IOException exception) {
                        throw new RuntimeException(exception);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Your password does not match.");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            }
        });

        this.add(parentPanel);
    }
}
