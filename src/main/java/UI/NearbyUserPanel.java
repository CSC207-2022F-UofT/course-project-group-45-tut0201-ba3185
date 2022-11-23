package UI;

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class NearbyUserPanel extends JPanel implements NearbyUserInterface {
    @Override
    public void update(int width, int height, NearbyUserViewModel viewModel){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setMaximumSize( this.getPreferredSize() );
        this.setBackground(Color.yellow);
        this.setBounds(0, 0, width,height);
    }
    //Todo: add 15 buttons.
}
