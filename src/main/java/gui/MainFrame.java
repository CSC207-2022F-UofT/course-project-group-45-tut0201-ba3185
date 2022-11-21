package gui;
import javax.swing.*;
import controller.userController;
import gui.LoginPageUI;

import java.awt.*;

public class MainFrame extends JFrame {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public MainFrame() {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        this.setResizable(false);

        userController controller = new userController();
        boolean isLoggedIn = controller.isUserLoggedin();
        System.out.println(isLoggedIn);
        // if user is logged in
        if(isLoggedIn) {
            this.getContentPane().removeAll();
            this.add(new MainPanel());
        }
        // If user is not logged in
        else {
            SignupPageUI signupPageUI = new SignupPageUI();
            this.getContentPane().removeAll();
            this.add(signupPageUI.getContentPane());
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
