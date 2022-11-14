package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // add app panel
        JPanel appPanel = new JPanel();
        appPanel.setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT / 11 * 10));
        appPanel.setLayout(new FlowLayout());
        appPanel.setMaximumSize( appPanel.getPreferredSize() );
        this.add(appPanel);

        // if in game, add game
        appPanel.add(new TwoTruthsAndALiePageScrollPane(new TwoTruthsAndALiePagePanel()));

        // add nav bar
        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT / 11));
        navBar.setLayout(new FlowLayout(FlowLayout.LEADING, 35, 0));
        navBar.setMaximumSize( navBar.getPreferredSize() );
        this.add(navBar);

        JButton homeButton = new JButton(new ImageIcon("images/navbar_home.png"));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        // homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        navBar.add(homeButton);

        JButton discoveryButton = new JButton(new ImageIcon("images/navbar_discovery.png"));
        discoveryButton.setOpaque(false);
        discoveryButton.setContentAreaFilled(false);
        // discoveryButton.setBorderPainted(false);
        discoveryButton.setFocusPainted(false);
        navBar.add(discoveryButton);

        JButton gameButton = new JButton(new ImageIcon("images/navbar_game.png"));
        gameButton.setOpaque(false);
        gameButton.setContentAreaFilled(false);
        // gameButton.setBorderPainted(false);
        gameButton.setFocusPainted(false);
        navBar.add(gameButton);

        JButton settingsButton = new JButton(new ImageIcon("images/navbar_settings.png"));
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        // settingsButton.setBorderPainted(false);
        settingsButton.setFocusPainted(false);
        navBar.add(settingsButton);
    }

}
