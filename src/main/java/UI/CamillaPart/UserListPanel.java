package UI.CamillaPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserListPanel extends JPanel {
    private ArrayList<String> userNames;//the userNames should be given
    public UserListPanel() {
        this.setLayout(new FlowLayout());
        this.add(new RecommendUserScrollPane(new RecommendUserPanel(userNames)));
    }
}
