package controller;

import use_case_discovery.DiscoveryInputBoundary;


public class DiscoveryController {
    private final int userOption;
    DiscoveryInputBoundary interactor;

    /**
     * @param userOption identify user's decision on which type of discovery
     */

    public DiscoveryController(int userOption, DiscoveryInputBoundary interactor){
        this.userOption = userOption;
        this.interactor = interactor;
    }

    public void optionControl(){
        //TODO: to fetch with other two types of discovery
        switch (userOption){
            case 1:
                this.interactor.create();
                break;

             case 2:
//                SearchAskerInputBoundary searchAsker = new SearchAsker(panel);
//                searchAsker.generateQuestion();
                break;
        }
    }
}