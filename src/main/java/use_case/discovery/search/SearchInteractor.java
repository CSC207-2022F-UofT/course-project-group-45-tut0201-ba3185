package use_case.discovery.search;

import use_case.discovery.DiscoveryListInterface;
import use_case.discovery.DiscoveryResponseModel;

import java.util.List;

/**
 * The search interactor takes user's answer and pass it to the list helper to
 * generate the recommended list. It then stores the list into response model and pass
 * it to view to update the UI.
 */
public class SearchInteractor implements SearchInputBoundary {

    private final DiscoveryListInterface pPanel;

    public DiscoveryResponseModel dResponseModel;

    /**
     * Search Interactor takes a panel in and update the panel after recommend list are generated
     * @param pPanel the panel we need to update.
     */
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
