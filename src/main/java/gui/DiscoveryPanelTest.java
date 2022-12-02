package gui;

import controller.DiscoveryController;
import controller.SearchController;
import use_case_discovery.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/*
To display the panel for discovery
 */
public class DiscoveryPanelTest extends JPanel {

    public DiscoveryPanelTest() {
        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.pink);
        // this.add(new JLabel("This is the discovery page."));
        //        this.add(new JLabel("To use the 'By preference', " +
        //                "click the scope image and click the button again to see another" +
        //                "user's info"));


        OptionPanel optionPanel = new OptionPanel();
        optionPanel.addActionListener(e -> {
            switch (e.getActionCommand()) {
                case "preference":
                    //UsersBtnPanel presenter = new UsersBtnPanel();
                    //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                    //DiscoveryController controller = new DiscoveryController(1,interactor);
                    //controller.optionControl();
                    //this.add(presenter);
                    this.add(new JLabel("this is display page"));
                    //panel.updatePanel();
                    break;
                case "search":
                    SearchQuestionPanel panelS = new SearchQuestionPanel();
                    DiscoveryInputBoundary interactor = new SearchAskerInteractor(panelS);
                    DiscoveryController controller = new DiscoveryController(interactor);
                    controller.trigger();
                    // panel.switchToQuestion(panelS);
                    if (panelS.flag == 0){
                        this.add(panelS);
                    }


                    if (panelS.flag == 1){
                        System.out.println("shabi");
                        //panelS.setVisible(false);
                        this.remove(panelS);
                        // DisplayPage displayPage = new DisplayPage("Search");
                       //  UsersBtnPanel panelP = displayPage.updatePageSearch(panelS.answerList);
                        this.add(new JLabel("this is display page"));
                        // this.revalidate();
                    }

                    break;

                case "nearBy":
//                    //UsersBtnPanel presenter = new UsersBtnPanel();
//                //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
//                //DiscoveryController controller = new DiscoveryController(1,interactor);
//                //controller.optionControl();
//                //this.add(presenter);
//                //this.add(new JLabel("this is display page"));
//                break;
//                break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }

}

