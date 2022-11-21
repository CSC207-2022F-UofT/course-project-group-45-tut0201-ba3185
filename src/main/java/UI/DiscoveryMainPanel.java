package UI;

import controller.FinderController;

import javax.swing.*;

public class DiscoveryMainPanel extends JPanel{

    private SearchQuestionPanel panelS;


    public DiscoveryMainPanel(int width, int height){
        this.setBounds(0,0,width, height);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        DisplayPage displayPage = new DisplayPage(width,height);

        panelS = new SearchQuestionPanel();


        OptionDisplayPanel optionDisplayPanel = new OptionDisplayPanel(width, height);
        optionDisplayPanel.addActionListener(e -> {
            optionDisplayPanel.removeAll();
            switch (e.getActionCommand()) {
                case "Preference":

                    this.add(displayPage);
                    break;
                case "Location":
                    this.add(displayPage);
                    break;
                case "Search":
                   // SearchAsker asker = new SearchAsker();
                    FinderController controller = new FinderController(3,panelS);
                    controller.optionControl();
                    this.add(panelS);
                    break;
            }
            this.revalidate();
        });

       // panelS.addActionListener(e -> {
       //     panelS.removeAll();
       //     switch (e.getActionCommand()) {
       //         case "submit":
       //             this.add(displayPage);
       //     }
       //     this.revalidate();
       //});

        this.add(optionDisplayPanel);

    }
}
