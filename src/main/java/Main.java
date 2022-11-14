import gui.MainPanel;

import javax.swing.*;


public class Main {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public static void main(String[] args) {

        // init app frame
        JFrame appFrame = new JFrame();
        appFrame.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        appFrame.setResizable(false);
        appFrame.getContentPane().setLayout(new BoxLayout(appFrame.getContentPane(), BoxLayout.PAGE_AXIS));

        // if logged in
        MainPanel mainPanel = new MainPanel();
        appFrame.add(mainPanel);

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}