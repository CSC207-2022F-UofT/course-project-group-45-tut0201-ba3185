package gui;

import javax.swing.*;
import java.awt.*;

public class DiscoveryPanel extends JPanel {
    public DiscoveryPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        int FRAME_WIDTH = 414;
        int FRAME_HEIGHT = 736;
        DiscoveryMainPanel panel =  new DiscoveryMainPanel(FRAME_WIDTH,FRAME_HEIGHT);
        this.add(panel);

    }
}
