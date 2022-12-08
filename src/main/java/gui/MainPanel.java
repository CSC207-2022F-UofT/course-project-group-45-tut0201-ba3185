package gui;

import gui.chat.FrontPagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JPanel {

    public MainPanel(MainFrameInterface frame) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setMaximumSize( this.getPreferredSize() );

        ContentPanel contentPanel = new ContentPanel();
        this.add(contentPanel);

        NavigationPanel navigationPanel = new NavigationPanel();
        navigationPanel.addActionListener(e -> {
            contentPanel.removeAll();
            switch (e.getActionCommand()) {
                case "frontPageButton":
                    contentPanel.add(new FrontPagePanel().createFrontPageScreen());
                    break;
                case "discoveryButton":
                    contentPanel.add(new DiscoveryPanel());
                    break;
                case "gameButton":
                    try {
                        contentPanel.add(new GamePanel());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "settingsButton":
                    contentPanel.add(new SettingsPanel(frame));
                    break;
            }
            contentPanel.revalidate();
        });
        this.add(navigationPanel);
    }

}