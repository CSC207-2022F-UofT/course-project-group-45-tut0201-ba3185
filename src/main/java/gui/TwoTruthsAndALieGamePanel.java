package gui;
import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALieGamePanel extends JPanel {
    public TwoTruthsAndALieGamePanel() {
        this.setSize(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3);
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3));

        this.setBackground(Color.cyan);

        JLabel label = new JLabel("Game");
        this.add(label);

        JButton gameButton = new JButton();
        gameButton.setText("Play game");
    }
}
