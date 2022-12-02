package controller;

import use_case_discovery.DiscoveryInputBoundary;


public class DiscoveryController {
    DiscoveryInputBoundary interactor;

    public DiscoveryController(DiscoveryInputBoundary interactor){
        this.interactor = interactor;
    }

    public void trigger() {
        this.interactor.create();
    }

}
