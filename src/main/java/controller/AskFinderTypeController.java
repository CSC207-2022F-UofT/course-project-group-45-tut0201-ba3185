package controller;

import use_case_discovery.DiscoveryOptionInputBoundary;


public class AskFinderTypeController {
    private DiscoveryOptionInputBoundary typeChooser;

    public AskFinderTypeController(DiscoveryOptionInputBoundary typeChooser){
        this.typeChooser = typeChooser;
    }

    public void userQuestionGenerator(){
        typeChooser.generateTypeOption();
    }

}
