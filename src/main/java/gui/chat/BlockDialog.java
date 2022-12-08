package gui.chat;

import javax.swing.*;
import java.awt.*;

public class BlockDialog extends JDialog {
    /**
     * Creates the pop-up window for block button
     */
    public BlockDialog(String msg) {
        setVisible(true);
        setBounds(500, 100, 200, 50);
        Container container = getContentPane();
        JLabel jLabel = new JLabel(msg);
        jLabel.setBounds(100,100,200,50);
        container.add(jLabel);
    }
}
