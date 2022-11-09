package controller;


import use_case_discovery.SearchAsker;
import use_case_discovery.SearchAskerInputBoundary;

import java.util.prefs.Preferences;

public class FinderController {
    private int userOption;
    private SearchAskerInputBoundary searchAsker;

    public FinderController(int userOption, SearchAskerInputBoundary searchAsker){
        this.userOption = userOption;
        this.searchAsker = searchAsker;
    }

    public void optionControl(){
        switch (userOption){
            case 1:
                PreferenceController preferenceController = new PreferenceController();
                // 用preferenceController. 里面的method 没有return 是void
                break;

            case 2:
                LocationController locationController = new LocationController();
                // 用locationController. 里面的method
                break;

            case 3:
                searchAsker.generateQuestion();
                break;
        }
    }
}
