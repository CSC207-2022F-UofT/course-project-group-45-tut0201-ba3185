package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NavigationPanel extends JPanel {

    private List<ActionListener> actionListeners;

    public NavigationPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 35, 0));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10));
        this.setMaximumSize( this.getPreferredSize() );

        this.actionListeners = new ArrayList<>();

        JButton homeButton = new JButton(new ImageIcon("images/navbar_chat.jpg"));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setActionCommand("frontPageButton");
        homeButton.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(homeButton);

        JButton discoveryButton = new JButton(new ImageIcon("images/navbar_discovery.png"));
        discoveryButton.setOpaque(false);
        discoveryButton.setContentAreaFilled(false);
        discoveryButton.setFocusPainted(false);
        discoveryButton.setActionCommand("discoveryButton");
        discoveryButton.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(discoveryButton);

        JButton gameButton = new JButton(new ImageIcon("images/navbar_game.png"));
        gameButton.setOpaque(false);
        gameButton.setContentAreaFilled(false);
        gameButton.setFocusPainted(false);
        gameButton.setActionCommand("gameButton");
        gameButton.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(gameButton);

        JButton settingsButton = new JButton(new ImageIcon("images/navbar_settings.png"));
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setActionCommand("settingsButton");
        settingsButton.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(settingsButton);
    }

    public void addActionListener(ActionListener a){
        if(!actionListeners.contains(a))
            actionListeners.add(a);
    }
}