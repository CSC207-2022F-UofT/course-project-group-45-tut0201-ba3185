package controller;

import use_case_discovery.DiscoveryInputBoundary;

/**
 * This controller call's the create method to generate the list
 */

public class DiscoveryController {
    DiscoveryInputBoundary interactor;

    public DiscoveryController(DiscoveryInputBoundary interactor){
        this.interactor = interactor;
    }

    public void trigger() {
        this.interactor.create();
    }

}
