package gui;
import javax.swing.*;
import java.awt.*;

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
                case "homeButton":
                    contentPanel.add(new HomePanel());
                    break;
                case "discoveryButton":
                    contentPanel.add(new DiscoveryPanelTest());
                    break;
                case "gameButton":
                    contentPanel.add(new GamePanel());
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
