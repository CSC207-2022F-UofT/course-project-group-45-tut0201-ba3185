package gui;

import javax.swing.*;
import java.awt.*;

public class DiscoveryPanel extends JPanel {
    int FRAME_WIDTH = 414;
    int FRAME_HEIGHT = 736;
    public DiscoveryPanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);

        //DiscoveryMainPanel panel =  new DiscoveryMainPanel();
        DiscoveryPanelTest panel =  new DiscoveryPanelTest();
        this.add(panel);

    }

    public void switchToDisplay() {
       // parameter DisplayPage displayPage
        // this.removeAll();
       // this.add(displayPage);
        this.add(new JLabel("this is display page"));
        this.revalidate();
    }
    public void switchToQuestion(SearchQuestionPanel searchQuestionPanel) {
        // parameter DisplayPage displayPage
        // this.removeAll();
        this.add(searchQuestionPanel);
        // this.add(new JLabel("this is display page"));
        this.revalidate();
    }
}
