package use_case_discovery;

/**
 * PreferenceFinder help find other users that also rank the interest
 * in a similar way by using a scoring system
 */
public class PreferenceInteractor implements DiscoveryInputBoundary {
    private final DiscoveryListInterface pPanel;
    /**
     * @param pPanel the panel that display the result of preference discovery
     */
    public PreferenceInteractor(DiscoveryListInterface pPanel){
        this.pPanel = pPanel;
    }
    @Override
    public void create() {
        //Set up response model to store info of userNames
        DiscoveryResponseModel dResponseModel = new DiscoveryResponseModel(new PreferenceListHelper().getList());
        pPanel.update(dResponseModel);
    }

}
