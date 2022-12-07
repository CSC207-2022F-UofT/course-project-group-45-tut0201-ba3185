package gui;

import controller.DiscoveryController;
import gui.discovery.OptionPanel;
import gui.discovery.SearchQuestionPanel;
import use_case_discovery.*;

import javax.swing.*;
import java.awt.*;

/**
 * This panel is the panel for discovery, the option panel are added to this
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
                    //UsersBtnPanel presenter = new UsersBtnPanel();
                    //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                    //DiscoveryController controller = new DiscoveryController(interactor);
                    //controller.optionControl();
                    //this.add(presenter);
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
                 //UsersBtnPanel presenter = new UsersBtnPanel();
                //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                //DiscoveryController controller = new DiscoveryController(1,interactor);
                //controller.optionControl();
                //this.add(presenter);
                 //this.add(new JLabel("this is display page"));
                  // break;
            }
            this.revalidate();
        });
        this.add(optionPanel);
    }

}

