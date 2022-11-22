package gui.discovery_part;

import gui.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PreferencePanel extends JPanel implements PreferencePanelInterface {
    private ArrayList<ActionListener> actionListeners;
    public PreferencePanel(){this.actionListeners = new ArrayList<>();}

    @Override
    public void update(int width, int height, PreferenceViewModel viewModel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 10 * 9));
        this.setMaximumSize( this.getPreferredSize() );
        this.setBackground(Color.yellow);
        this.setBounds(0, 0, width,height);


        JButton btn1 = new JButton(viewModel.getUserName1());
        btn1.addActionListener(e -> {
            for(ActionListener listener: actionListeners){
                listener.actionPerformed(e);
            }
        });
        this.add(btn1);
        JButton btn2 = new JButton(viewModel.getUserName2());
        this.add(btn2);
        this.revalidate();
        //TODO: 15 buttons are supposed to be created after fetch with user
//        Button btn3 = new Button(viewModel.userName3);
//        add(btn3.getButton());
//
//        Button btn4 = new Button(viewModel.userName4);
//        add(btn4.getButton());
//
//        Button btn5 = new Button(viewModel.userName5);
//        add(btn5.getButton());
//
//        Button btn6 = new Button(viewModel.userName6);
//        add(btn6.getButton());
//
//        Button btn7 = new Button(viewModel.userName7);
//        add(btn7.getButton());
//
//        Button btn8 = new Button(viewModel.userName8);
//        add(btn8.getButton());
//
//        Button btn9 = new Button(viewModel.userName9);
//        add(btn9.getButton());
//
//        Button btn10 = new Button(viewModel.userName10);
//        add(btn10.getButton());
//
//        Button btn11 = new Button(viewModel.userName11);
//        add(btn11.getButton());
//
//        Button btn12 = new Button(viewModel.userName12);
//        add(btn12.getButton());
//
//        Button btn13 = new Button(viewModel.userName13);
//        add(btn13.getButton());
//
//        Button btn14 = new Button(viewModel.userName14);
//        add(btn14.getButton());
//
//        Button btn15 = new Button(viewModel.userName15);
//        add(btn15.getButton());
//


    }
    public void addActionListener(ActionListener a){
        if(!actionListeners.contains(a))
            actionListeners.add(a);
    }
}
