package screens;
//import presenter.FrontPagePresenter;
//import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrontPage extends JPanel implements ActionListener {
    int page_h;
    int page_w;
    ArrayList<String> list;
    JPanel frontPageScreen;
    FrontPageViewModel fpViewModel;

    public FrontPage(int page_h, int page_w, ArrayList<String> list, FrontPageViewModel viewModel) {
        this.page_w = page_w;
        this.page_h = page_h;
        this.list = list;
        this.fpViewModel = viewModel;
    }

    public JScrollPane createFrontPageScreen() {
        int screen_h = page_h * 9 / 10; //the screen is 90% of our page size. quote from Eric.

        this.frontPageScreen = new JPanel();//initialize our FrontPageScreen
        frontPageScreen.setLayout(new BoxLayout(frontPageScreen, BoxLayout.Y_AXIS));
        frontPageScreen.setSize(page_w, screen_h); //(w = 414, h = 736*0.9)
        Color color = new Color(246, 186, 227);
        frontPageScreen.setBackground(color);


        for (String i : fpViewModel.getMessages()) {
            JButton button = new JButton();
            button.setText(i);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            frontPageScreen.add(button);
            button.addActionListener(this);

        }

        JScrollPane scrollPane = new JScrollPane(frontPageScreen, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setSize(page_w, screen_h);
        return scrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String targetUserId = ((JButton)e.getSource()).getText();//get which user we want to chat with by clicking
        //ChatScreen c = new ChatScreen(targetUserId,);      where can I get messageViewModel
        this.frontPageScreen.setVisible(false);
    }
}
