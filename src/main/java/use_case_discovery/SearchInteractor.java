package use_case_discovery;

import java.util.List;

public class SearchInteractor implements SearchInputBoundary {

    // private DiscoveryListOutputBoundary presenter;
    private final DiscoveryListPresenter pPanel;

    // private SearchAnswerRequestModel model;
    public SearchInteractor(DiscoveryListPresenter pPanel){
        this.pPanel = pPanel;
    }



    public void recommendListGenerator(SearchAnswerRequestModel model){

        //HashMap<User, Integer> UserListWithScore = new HashMap<User, Integer>();

       // for(User user: userList){
       //     UserListWithScore.put(user, getScore(user));
       // }
        // create the list of recommended user
        SearchListHelper listHelper = new SearchListHelper(model);
        List recommendList = listHelper.getList();
        //create a response model for the user
        DiscoveryResponseModel dResponseModel = new DiscoveryResponseModel(recommendList);

        // use the helper function and this will return a sorted list with list of username and score
        // PreferenceScoreHelper preferenceScoreHelper = new PreferenceScoreHelper(UserListWithScore);
        // ArrayList<String> recommendList = preferenceScoreHelper.getList(); // return a list

        pPanel.update(dResponseModel);

    }

}
