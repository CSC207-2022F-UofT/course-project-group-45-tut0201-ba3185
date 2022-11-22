package UI;

import javax.swing.*;

class gui {

    public static void main(String args[]) {
        int FRAME_WIDTH = 414;
        int FRAME_HEIGHT = 736;


        JFrame jf = new JFrame();
        jf.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        DiscoveryMainPanel panel =  new DiscoveryMainPanel(FRAME_WIDTH,FRAME_HEIGHT);

        jf.add(panel);

        jf.setVisible(true);
    }
}