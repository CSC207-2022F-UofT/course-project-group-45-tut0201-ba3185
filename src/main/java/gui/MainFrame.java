package gui;
import javax.swing.*;
import controller.userController;
import use_case_message.MessageManagers;

import java.io.*;

public class MainFrame extends JFrame implements MainFrameInterface {
    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;
    public static MessageManagers messageManagers;

    public MainFrame() {
        messageManagers = new MessageManagers();
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("src/main/java/database/MessageManagers.ser"));
            messageManagers = (MessageManagers) input.readObject();
            input.close();
        }
        catch (IOException ioe){
            // This will run at the first time of running the program since there's no such file before running.
            System.err.println("Error opening file.");
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("Object read is not a MessageManagers");
        }

        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        this.setResizable(false);

        userController controller = new userController();
        boolean isLoggedIn = controller.isUserLoggedin();
        System.out.println(isLoggedIn);
        // if user is logged in
        if(isLoggedIn) {
            this.getContentPane().removeAll();
            this.add(new MainPanel(this));
        }
        // If user is not logged in
        else {
            this.getContentPane().removeAll();
            SignupPageUI signupPageUI = new SignupPageUI(this);
            this.add(signupPageUI);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void switchToLogin() {
        this.getContentPane().removeAll();
        LoginPageUI loginPageUI = new LoginPageUI(this);
        this.add(loginPageUI);
        this.revalidate();
    }

    public void switchToSignup() {
        this.getContentPane().removeAll();
        SignupPageUI signupPageUI = new SignupPageUI(this);
        this.add(signupPageUI);
        this.revalidate();
    }

    public void switchToMain() {
        this.getContentPane().removeAll();
        this.add(new MainPanel(this));
        this.revalidate();
    }
    public void switchToInitSetup(String username, String name, String password) {
        this.getContentPane().removeAll();
        InitialSettingPageUI initialSettingPageUI = new InitialSettingPageUI(this, username, name, password);
        this.add(initialSettingPageUI);
        this.revalidate();
    }
}