package screens;

import javax.swing.*;
import java.awt.*;

public class BlockDialog extends JDialog {

    public BlockDialog(String msg) {
        setVisible(true);
        setBounds(500, 100, 200, 50);
        Container container = getContentPane();
        JLabel jLabel = new JLabel(msg);
        jLabel.setBounds(100,100,200,50);
        container.add(jLabel);
    }
}
