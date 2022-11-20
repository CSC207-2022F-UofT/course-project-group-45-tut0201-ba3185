package gui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SpringLayout.*;

public class LoginSignupPageUI extends JPanel {
    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public LoginSignupPageUI() {
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new SpringLayout());
        SpringLayout parentLayout = (SpringLayout) this.getLayout();

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

        // Populating the panel

        JPanel fieldPanel = new JPanel(new SpringLayout());
        fieldPanel.setPreferredSize(new Dimension(PAGE_WIDTH/2,PAGE_HEIGHT/5));

        fieldPanel.add(usernameTextField);
        fieldPanel.add(nameTextField);
        fieldPanel.add(passwordField);
        fieldPanel.add(username);
        fieldPanel.add(name);
        fieldPanel.add(password);

        SpringLayout fieldLayout = (SpringLayout) fieldPanel.getLayout();

        // Putting Label on West wall
        fieldLayout.putConstraint(WEST, name, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(WEST, username, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(WEST, password, 0, WEST, fieldPanel);
        fieldLayout.putConstraint(NORTH, name, 10, NORTH, fieldPanel);

        // distance between Label
        fieldLayout.putConstraint(NORTH, username, 30, SOUTH, name);
        fieldLayout.putConstraint(NORTH, password, 30, SOUTH, username);

        // Put Field to the East wall
        fieldLayout.putConstraint(EAST, nameTextField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, usernameTextField,0 ,EAST, fieldPanel);
        fieldLayout.putConstraint(EAST, passwordField,0 ,EAST, fieldPanel);

        // Label and Field on same horizontal
        fieldLayout.putConstraint(NORTH,nameTextField, 7, NORTH, fieldPanel);
        fieldLayout.putConstraint(NORTH, usernameTextField, 20, SOUTH, nameTextField);
        fieldLayout.putConstraint(NORTH, passwordField, 20, SOUTH, usernameTextField);

        // Creating TextPanel
        JPanel textPanel = new JPanel(new SpringLayout());
        textPanel.setPreferredSize(new Dimension(PAGE_WIDTH,100));
        SpringLayout textLayout = (SpringLayout) textPanel.getLayout();

        // Creating text and populating textPanel
        JLabel Title = new JLabel("Sign up!");
        Title.setFont(new Font("Helvetica", Font.BOLD , 28));
        textPanel.add(Title);

        // Layout for Text Panel
        textLayout.putConstraint(HORIZONTAL_CENTER, Title, 0, HORIZONTAL_CENTER, textPanel);

        // Creating button Panel
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


        // Button listener
        SignupButton.addActionListener( ae -> {

        });

        switchView.addActionListener( ae -> {
            this.remove(fieldPanel);
            this.remove(buttonPanel);
            this.remove(textPanel);
            this.add(new LoginPageUI());
        });


        this.add(fieldPanel);
        this.add(buttonPanel);
        this.add(textPanel);
    }
}
