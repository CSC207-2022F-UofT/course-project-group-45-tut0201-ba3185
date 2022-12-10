package use_case.discovery.peference;

import use_case.discovery.DiscoveryInputBoundary;
import use_case.discovery.DiscoveryListInterface;
import use_case.discovery.DiscoveryResponseModel;

/**
 * PreferenceFinder help find other users that also rank the interest
 * in a similar way by using a scoring system
 */
public class PreferenceInteractor implements DiscoveryInputBoundary {
    private final DiscoveryListInterface presenter;
    public DiscoveryResponseModel dResponseModel;
    /**
     * @param pPanel the panel that display the result of preference discovery
     */
    public PreferenceInteractor(DiscoveryListInterface pPanel){
        this.presenter = pPanel;
        this.dResponseModel = new DiscoveryResponseModel(new PreferenceListHelper().getList());
    }
    @Override
    public void create() {
        presenter.update(this.dResponseModel);
    }

}