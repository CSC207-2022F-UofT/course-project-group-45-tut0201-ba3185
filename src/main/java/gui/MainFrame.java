package gui;
import javax.swing.*;

public class MainFrame extends JFrame {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public MainFrame() {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        this.setResizable(false);

        // if logged in
        this.getContentPane().removeAll();
        this.add(new MainPanel());

        // TODO: if not logged in

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
