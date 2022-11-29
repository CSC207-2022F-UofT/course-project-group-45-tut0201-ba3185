package gui;
import gui.discovery_part.OptionPanel;
import gui.discovery_part.UsersBtnPanel;
import use_case.discovery.DiscoveryInputBoundary;
import controller.DiscoveryController;
import use_case.discovery.PreferenceInteractor;

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
//                    UsersBtnPanel presenter = new UsersBtnPanel();
//                    DiscoveryInputBoundary interactor = new NearByInteractor(presenter);
//                    DiscoveryController controller = new DiscoveryController(1,interactor);
//                    controller.optionControl();
//                    this.add(presenter);
                    break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }
}
