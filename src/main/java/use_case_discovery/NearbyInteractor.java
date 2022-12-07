package use_case_discovery;


public class NearbyInteractor implements DiscoveryInputBoundary{

    //public DiscoveryListOutputBoundary presenter;
    private final DiscoveryListInterface pPanel;

    /**
     *
     * @param pPanel used to display the result of Nearby discovery (15 nearest users)
     */

    public NearbyInteractor(DiscoveryListInterface pPanel){
        this.pPanel = pPanel;
    }

    @Override
    public void create(){
        //set up a response model that store the 15 usernames that generated by GetNearbyUserHelper
        DiscoveryResponseModel dResponseModel = new DiscoveryResponseModel(new GetNearbyUserHelper().getList());
        pPanel.update(dResponseModel);
    }
}