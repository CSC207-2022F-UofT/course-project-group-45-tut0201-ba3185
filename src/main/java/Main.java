import javax.swing.*;
import gui.LoginSignupPageUI;
import gui.SignupPageUI;

public class Main {
    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;
    public static void main(String[] args) {
        // init the frame
        /*JFrame appFrame = new JFrame();
        appFrame.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        appFrame.setResizable(false);
        appFrame.getContentPane().setLayout(new BoxLayout(appFrame.getContentPane(), BoxLayout.PAGE_AXIS));

        // setting the frame as the login
        RegisterScreenFrame registerScreenFrame = new RegisterScreenFrame();

        appFrame.add(registerScreenFrame);

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);*/
        SignupPageUI signupPageUI = new SignupPageUI();
        signupPageUI.setVisible(true);
    }
}
