package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoTruthsAndALiePagePanel extends JPanel {

    public TwoTruthsAndALiePagePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (int i = 0; i < 5; i++) {
            TwoTruthsAndALieGameUI game = new TwoTruthsAndALieGameUI();
            this.add(game);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }
}
