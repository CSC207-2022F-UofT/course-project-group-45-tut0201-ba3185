package gui;

import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALiePageScrollPane extends JScrollPane {

    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;

    public TwoTruthsAndALiePageScrollPane(TwoTruthsAndALiePagePanel twoTruthsAndALiePagePanel) {
        super(twoTruthsAndALiePagePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        this.setPreferredSize(new Dimension(PAGE_WIDTH,PAGE_HEIGHT / 11 * 10));
    }
}
