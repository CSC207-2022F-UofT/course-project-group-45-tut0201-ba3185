package use_case_discovery;

import java.util.List;

public class SearchInteractor implements SearchInputBoundary {

    private final DiscoveryListInterface pPanel;

    public DiscoveryResponseModel dResponseModel;

    public SearchInteractor(DiscoveryListInterface pPanel){
        this.pPanel = pPanel;
    }

    /**
     * call the helper function to generate the recommended list.
     * @param model request model that stores the information got from the UI and passed by
     *              controller.
     */
    public void recommendListGenerator(SearchAnswerRequestModel model){

        // call the list helper
        SearchListHelper listHelper = new SearchListHelper(model);
        List<String> recommendList = listHelper.getList();

        //create a response model for the user
        dResponseModel = new DiscoveryResponseModel(recommendList);
        pPanel.update(dResponseModel); // update the panel by calling the update method and pass the request model

    }

}
