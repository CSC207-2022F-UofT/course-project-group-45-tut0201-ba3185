package gui;

import gui.game.TwoTruthsAndALiePagePanel;
import gui.game.TwoTruthsAndALiePageScrollPane;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {
    public GamePanel() throws IOException {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH,MainFrame.PAGE_HEIGHT / 10 * 9));
        this.add(new TwoTruthsAndALiePageScrollPane(new TwoTruthsAndALiePagePanel()));
    }
}
