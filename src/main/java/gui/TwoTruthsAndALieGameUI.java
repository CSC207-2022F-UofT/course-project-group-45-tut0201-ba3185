package gui;
import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALieGameUI extends JPanel {
    public TwoTruthsAndALieGameUI() {
        this.setSize(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3);
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3));

        this.setBackground(Color.cyan);

        JLabel label = new JLabel("Game");
        this.add(label);

        JButton button = new JButton();
        button.setText("Press to Win");
        this.add(button);
    }
}
