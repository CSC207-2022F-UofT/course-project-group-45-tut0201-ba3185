package UI;

import javax.swing.*;

public class DisplayPage extends JPanel{
    public DisplayPage(int width, int height){
        this.setBounds(0,0,width, height);
        this.add(new JLabel("display page"));

    }

}
