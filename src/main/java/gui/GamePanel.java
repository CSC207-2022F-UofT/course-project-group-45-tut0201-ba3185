package gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        this.setLayout(new FlowLayout());
        this.add(new TwoTruthsAndALiePageScrollPane(new TwoTruthsAndALiePagePanel()));
    }
}
