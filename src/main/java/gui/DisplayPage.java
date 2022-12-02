package gui;

import controller.SearchController;
import use_case_discovery.SearchInputBoundary;
import use_case_discovery.SearchInteractor;

import javax.swing.*;
import java.util.List;

public class DisplayPage extends JPanel{
    public static final int PAGE_WIDTH = 414;
    public static final int PAGE_HEIGHT = 736;
    public DiscoveryPanel panel = new DiscoveryPanel();
    public static int flag = 0;
    private String type;
    public DisplayPage(String type){
        this.type = type;
        this.setBounds(0,0,PAGE_WIDTH, PAGE_HEIGHT);
    }
    public void updatePage(){
        switch (type) {
            case "Preference":
                //UsersBtnPanel presenter = new UsersBtnPanel();
                //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                //DiscoveryController controller = new DiscoveryController(1,interactor);
                //controller.optionControl();
                //this.add(presenter);
                //this.add(new JLabel("this is display page"));
                //panel.updatePanel();
                break;
            case "Location":
                //UsersBtnPanel presenter = new UsersBtnPanel();
                //DiscoveryInputBoundary interactor = new PreferenceInteractor(presenter);
                //DiscoveryController controller = new DiscoveryController(1,interactor);
                //controller.optionControl();
                //this.add(presenter);
                //this.add(new JLabel("this is display page"));
                break;

        }
    }

    public UsersBtnPanel updatePageSearch(List<Integer> answerList){
        UsersBtnPanel usersBtnPanel = new UsersBtnPanel();
        SearchInputBoundary searchInteractor = new SearchInteractor(usersBtnPanel);
        SearchController controller = new SearchController(answerList, searchInteractor);
        controller.matchAnswer();
        controller.generateRecommendation();
        return usersBtnPanel;
    }

}
