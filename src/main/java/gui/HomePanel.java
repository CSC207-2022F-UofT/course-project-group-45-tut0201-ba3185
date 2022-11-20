package gui;
import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.add(new TextField("This is the home page."));
    }
}
