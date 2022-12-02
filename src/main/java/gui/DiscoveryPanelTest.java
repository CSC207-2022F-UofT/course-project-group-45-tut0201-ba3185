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
    private UsersBtnPanel panelP;

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
                    // this.add(new JLabel("this is display page"));
                    //panel.updatePanel();
                    break;
                case "search":
                    SearchQuestionPanel panelS = new SearchQuestionPanel();
                    DiscoveryInputBoundary interactor = new SearchAskerInteractor(panelS);
                    DiscoveryController controller = new DiscoveryController(interactor);
                    controller.trigger();
                    this.add(panelS);

                    break;

                case "nearBy":
//                 //UsersBtnPanel presenter = new UsersBtnPanel();
//                //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
//                //DiscoveryController controller = new DiscoveryController(1,interactor);
//                //controller.optionControl();
//                //this.add(presenter);
//                //this.add(new JLabel("this is display page"));
//                break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }

}

