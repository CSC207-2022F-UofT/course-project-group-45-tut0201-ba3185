package gui;
import gui.discovery.OptionPanel;
import gui.discovery.SearchQuestionPanel;
import gui.discovery.UsersBtnPanel;
import use_case_discovery.DiscoveryInputBoundary;
import controller.DiscoveryController;
import use_case_discovery.PreferenceInteractor;
import use_case_discovery.SearchAskerInteractor;

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


        OptionPanel optionPanel = new OptionPanel();
        optionPanel.addActionListener(e -> {
            switch (e.getActionCommand()) {
                case "preference":
                    UsersBtnPanel presenter = new UsersBtnPanel();
                    DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                    DiscoveryController controller = new DiscoveryController(interactor);
                    controller.trigger();
                    this.removeAll();
                    //this.add(this);
                    this.add(presenter);

                    break;
                case "search":
                    SearchQuestionPanel panelS = new SearchQuestionPanel();
                    DiscoveryInputBoundary interactorS = new SearchAskerInteractor(panelS);
                    DiscoveryController controllerS = new DiscoveryController(interactorS);
                    controllerS.trigger();
                    this.removeAll();
                    this.add(panelS);

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
