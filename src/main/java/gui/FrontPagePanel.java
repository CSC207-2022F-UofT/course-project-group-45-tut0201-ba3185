package gui;
import javax.swing.*;
import java.awt.*;

public class FrontPagePanel extends JPanel implements ActionListener {
    int page_h;
    int page_w;
    JPanel frontPageScreen;


    public FrontPagePanel() {
        //this.page_w = MainFrame.PAGE_WIDTH;
        //this.page_h = MainFrame.PAGE_HEIGHT;

    }

    public JScrollPane createFrontPageScreen() {
        //initialize our FrontPageScreen

        this.frontPageScreen = new JPanel();
        frontPageScreen.setLayout(new BoxLayout(frontPageScreen, BoxLayout.Y_AXIS));
        //int screen_h = page_h * ;
        //frontPageScreen.setSize(page_w, screen_h); //(w = 414, h = 736*0.9)
        Color color = new Color(246, 186, 227);
        frontPageScreen.setBackground(color);

        JScrollPane scrollPane = new JScrollPane(frontPageScreen, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setSize(page_w, screen_h);
        return scrollPane;
    }

    public void loadUser(String username){
        JButton button = new JButton();
        button.setText(username);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        frontPageScreen.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   //when user clicked the userbutton they want to chat with, a chatScreen is generated
        String targetUserId = ((JButton) e.getSource()).getText();
        ChatScreen c = new ChatScreen(targetUserId);
        c.create();
    }
}
