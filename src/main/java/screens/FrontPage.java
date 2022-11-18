package screens;
import javax.swing.*;

public class FrontPage extends JPanel{
    public FrontPage(int page_h, int page_w, MessageController controller, ChatOutputBoundary chatOutputBoundary){
        int screen_h = page_h * 9/10; //the screen is 90% of our page size. quote from Eric.


        JPanel frontPageScreen = new JPanel();//initialize our FrontPageScreen
        frontPageScreen.setSize(page_w, screen_h); //(w = 414, h = 736*0.9)

    }
}
