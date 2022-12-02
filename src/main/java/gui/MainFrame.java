package gui;
import javax.swing.*;
import controller.userController;

public class MainFrame extends JFrame implements MainFrameInterface {

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
        this.add(new MainPanel());
        this.revalidate();
    }
    public void switchToInitSetup(String username, String name, String password) {
        this.getContentPane().removeAll();
        InitialSettingPageUI initialSettingPageUI = new InitialSettingPageUI(this, username, name, password);
        this.add(initialSettingPageUI);
        this.revalidate();
    }
}