package gui;
import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the settings page."));
    }
}
