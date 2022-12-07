package gui;
import use_case_discovery.DiscoveryInputBoundary;
import controller.DiscoveryController;
import use_case_discovery.NearbyInteractor;
import use_case_discovery.PreferenceInteractor;

import javax.swing.*;
import java.awt.*;

/*
To display the panel for discovery
 */
public class DiscoveryPanel extends JPanel {
    public DiscoveryPanel() {
        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.pink);
        this.add(new JLabel("This is the discovery page."));
        //        this.add(new JLabel("To use the 'By preference', " +
        //                "click the scope image and click the button again to see another" +
        //                "user's info"));


        OptionPanel optionPanel = new OptionPanel();
        optionPanel.addActionListener(e -> {
            switch (e.getActionCommand()) {
                case "preference":
                    UsersBtnPanel presenter = new UsersBtnPanel();
                    DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                    DiscoveryController controller = new DiscoveryController(1,interactor);
                    controller.optionControl();
                    this.add(presenter);
                    break;
                case "search":
//                    //the controller of search
                    break;
                case "nearBy":
                    UsersBtnPanel presenter1 = new UsersBtnPanel();
                    DiscoveryInputBoundary interactor1 = new NearbyInteractor(presenter1);
                    DiscoveryController controller1 = new DiscoveryController(1,interactor1);
                    controller1.optionControl();
                    this.add(presenter1);
                    break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }
}