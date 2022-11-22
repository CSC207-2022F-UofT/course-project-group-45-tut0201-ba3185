package Discovery.DiscoveryUseCase;
import Discovery.DiscoveryPresenter.PreferencePresenter;
import User.UserForTest;
import gui.discovery_part.PreferencePanelInterface;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * PreferenceFinder help find other users that also rank the interest
 * in a similar way by using a scoring system
 */
public class PreferenceFinder implements PreferenceFinderInputBoundary{
    //TODO: fetch with User Class
    ArrayList<String> testMainUserInterestRank = new TestUser().mainUser.getInterestRank();
    public DiscoveryListOutputBoundary presenter;
    private DiscoveryResponseModel DResponseModel;
    private PreferencePanelInterface pPanel;
    private ArrayList<String> returnUserNames;
    ArrayList<UserForTest> afterGenderFinder = new GenderFinder().getList();

    /**
     *
     * @param pPanel the panel that display the result of preference discovery
     */

    public PreferenceFinder(PreferencePanelInterface pPanel){
        this.pPanel = pPanel;
        HashMap<UserForTest, Integer> scoreStorage = new HashMap<>();
        for (UserForTest otherUser:afterGenderFinder){
            PreferenceFinderHelper tempPreferenceFinderHelper = new PreferenceFinderHelper(otherUser,
                    testMainUserInterestRank);
            scoreStorage.put(otherUser, tempPreferenceFinderHelper.getScore());
        }
        PreferenceScoreHelper tempPreferenceScoreHelper = new PreferenceScoreHelper(scoreStorage);
        this.returnUserNames = tempPreferenceScoreHelper.getList();
    }

    @Override
    public void recommendListGenerator() {
        //Set up response model to store info of userNames
        this.DResponseModel = new DiscoveryResponseModel();
        this.DResponseModel.setUserNames(this.returnUserNames);
        //presenter takes the panel and response model for information
        this.presenter = new PreferencePresenter(this.pPanel, DResponseModel);
        this.presenter.displayList();
    }

}
