package use_case.discovery.nearBy;


import use_case.discovery.DiscoveryInputBoundary;
import use_case.discovery.DiscoveryListInterface;
import use_case.discovery.DiscoveryResponseModel;
import use_case.discovery.nearBy.GetNearbyUserHelper;

public class NearbyInteractor implements DiscoveryInputBoundary {
    private final DiscoveryListInterface presenter;
    public DiscoveryResponseModel dResponseModel;
    /**
     * @param pPanel the panel that display the result of nearby discovery
     */
    public NearbyInteractor(DiscoveryListInterface pPanel){
        this.presenter = pPanel;
        this.dResponseModel = new DiscoveryResponseModel(new GetNearbyUserHelper().getList());
    }
    @Override
    public void create() {
        //Set up response model to store info of userNames
        presenter.update(this.dResponseModel);
    }

}
