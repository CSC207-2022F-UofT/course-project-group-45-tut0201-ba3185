package gui;
import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALiePageScrollPane extends JScrollPane {

    public TwoTruthsAndALiePageScrollPane(TwoTruthsAndALiePagePanel twoTruthsAndALiePagePanel) {
        super(twoTruthsAndALiePagePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH,MainFrame.PAGE_HEIGHT / 10 * 9));
    }
}
