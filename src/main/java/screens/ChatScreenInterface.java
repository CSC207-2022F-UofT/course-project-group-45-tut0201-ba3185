package screens;

import javax.swing.*;

public interface ChatScreenInterface {
     int PAGE_W = 414;
     int PAGE_H = 736;
     JPanel create();
     //void actionPerformed(ActionEvent e);
     void loadChat(String msg);
}
