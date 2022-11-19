package screens;
//import presenter.FrontPagePresenter;
//import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageViewModel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrontPage extends JPanel{
    public FrontPage(int page_h, int page_w, FrontPageViewModel fpViewModel){
        int screen_h = page_h * 9/10; //the screen is 90% of our page size. quote from Eric.


        JPanel frontPageScreen = new JPanel();//initialize our FrontPageScreen
        frontPageScreen.setSize(page_w, screen_h); //(w = 414, h = 736*0.9)
        Color color = new Color(204, 255, 255);
        frontPageScreen.setBackground(color);
        setLayout(new BoxLayout(frontPageScreen, BoxLayout.Y_AXIS));


        JPanel chatBoxPanel = new JPanel();
        ArrayList<String> message = fpViewModel.getMessages();

        for ( String i : message){
            JButton button = new JButton();
            button.setSize(100, 50);
            button.setText(i);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            chatBoxPanel.add(button);
        }



    }
}
