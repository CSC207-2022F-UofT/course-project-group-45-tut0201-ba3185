package gui;

import controller.DiscoveryController;
import use_case_discovery.DiscoveryInputBoundary;
import use_case_discovery.SearchAskerInteractor;

import javax.swing.*;

public class DiscoveryMainPanel extends JPanel{
    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;
    // public DiscoveryPanel panel = new DiscoveryPanel();


    public DiscoveryMainPanel(){
        this.setBounds(0,0,PAGE_WIDTH, PAGE_HEIGHT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        OptionPanel optionDisplayPanel = new OptionPanel();
        optionDisplayPanel.addActionListener(e -> {
            // optionDisplayPanel.removeAll();
            switch (e.getActionCommand()) {
                case "preference":
                    DisplayPage preferenceDisplayPage = new DisplayPage("Preference");
                    preferenceDisplayPage.updatePage();
                    // this.add();
                    //panel.switchToDisplay(preferenceDisplayPage);
                    // panel.switchToDisplay();
                    break;
                case "nearby":
                    DisplayPage locationDisplayPage = new DisplayPage("Location");
                    locationDisplayPage.updatePage();
                    this.add(locationDisplayPage);
                    // panel.switchToDisplay(preferenceDisplayPage);
                    // panel.switchToDisplay();
                    break;
                case "search":
                    SearchQuestionPanel panelS = new SearchQuestionPanel();
                    DiscoveryInputBoundary interactor = new SearchAskerInteractor(panelS);
                    DiscoveryController controller = new DiscoveryController(interactor);
                    controller.trigger();
                    // panel.switchToQuestion(panelS);
                    this.add(panelS);
                    break;
            }
            this.revalidate();
        });
        this.add(optionDisplayPanel);
    }
}
