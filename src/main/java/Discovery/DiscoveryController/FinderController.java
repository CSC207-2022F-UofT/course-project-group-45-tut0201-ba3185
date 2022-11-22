package Discovery.DiscoveryController;
import Discovery.DiscoveryUseCase.PreferenceFinder;
import Discovery.DiscoveryUseCase.PreferenceFinderInputBoundary;
import gui.discovery_part.PreferencePanelInterface;

public class FinderController {
    private int userOption;
    PreferencePanelInterface pPanel;

    /**
     *
     * @param userOption identify user's decision on which type of discovery
     * @param pPanel the panel that display the result of preference discovery
     */

    public FinderController(int userOption, PreferencePanelInterface pPanel){
        this.userOption = userOption;
        this.pPanel = pPanel;
    }

    public void optionControl(){
        //TODO: to fetch with other two types of discovery
        switch (userOption){
            case 1:
               PreferenceFinderInputBoundary preferencesFinderIB = new PreferenceFinder(this.pPanel);
               preferencesFinderIB.recommendListGenerator();
               break;

            //case 2:
            //    LocationFinder locationFinder = new LocationFinder();
            //    locationFinder.getNearbyUser();
            //    break;

            /*case 3:
                SearchAskerInputBoundary searchAsker = new SearchAsker(panel);
                searchAsker.generateQuestion();
                break;*/
        }
    }
}
