package use_case_discovery;


public class NearbyInteractor implements DiscoveryInputBoundary {
    private final DiscoveryListInterface presenter;
    public DiscoveryResponseModel dResponseModel;
    /**
     * @param pPanel the panel that display the result of nearby discovery
     */
    public NearbyInteractor(DiscoveryListInterface pPanel){
        this.presenter = pPanel;
        this.dResponseModel = new DiscoveryResponseModel(new PreferenceListHelper().getList());
    }
    @Override
    public void create() {
        //Set up response model to store info of userNames
        presenter.update(this.dResponseModel);
    }

}
