package gui;
import javax.swing.*;
import java.awt.*;

public class DiscoveryPanel extends JPanel {
    public DiscoveryPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the discovery page."));
    }
}
