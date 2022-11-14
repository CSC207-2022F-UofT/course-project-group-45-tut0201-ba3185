package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoTruthsAndALiePagePanel extends JPanel {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public TwoTruthsAndALiePagePanel() {
        // display game page to app panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < 5; i++) {
            TwoTruthsAndALieGameUI game = new TwoTruthsAndALieGameUI();

            JLabel label = new JLabel("Game: " + i);
            game.add(label);

            JButton button = new JButton();
            button.setText("Press to Win");
            game.add(button);
            game.setSize(PAGE_WIDTH, PAGE_HEIGHT / 3);
            game.setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT / 3));
            game.setBackground(Color.cyan);
            this.add(game);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }
}
