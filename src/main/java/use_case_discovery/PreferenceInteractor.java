package use_case_discovery;

/**
 * PreferenceFinder help find other users that also rank the interest
 * in a similar way by using a scoring system
 */
public class PreferenceInteractor implements DiscoveryInputBoundary {
    //public DiscoveryListOutputBoundary presenter;
    private final Presenter pPanel;

    /**
     *
     * @param pPanel the panel that display the result of preference discovery
     */

    public PreferenceInteractor(Presenter pPanel){
        this.pPanel = pPanel;
    }


    @Override
    public void create() {
        //Set up response model to store info of userNames
        DiscoveryResponseModel dResponseModel = new DiscoveryResponseModel(new PreferenceListHelper().getList());
        //presenter takes the panel and response model for information
//        this.presenter = new PreferencePresenter(this.pPresenter, dResponseModel);
//        this.presenter.displayList();
        pPanel.update(dResponseModel);
    }

}