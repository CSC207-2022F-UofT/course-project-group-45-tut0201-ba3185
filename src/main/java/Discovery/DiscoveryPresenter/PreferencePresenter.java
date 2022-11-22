package Discovery.DiscoveryPresenter;

import Discovery.DiscoveryUseCase.DiscoveryListOutputBoundary;
import Discovery.DiscoveryUseCase.DiscoveryResponseModel;
import gui.discovery_part.PreferencePanelInterface;
import gui.discovery_part.PreferenceViewModel;

import java.util.ArrayList;

public class PreferencePresenter implements DiscoveryListOutputBoundary {
    private DiscoveryResponseModel discoveryResponseModel;
    private ArrayList<String> userNames;
    private PreferenceViewModel viewModel = new PreferenceViewModel();
    private PreferencePanelInterface pPanel;

    /**
     *
     * @param pPanel the panel that display the result of preference discovery
     * @param discoveryResponseModel stores the userNames of users that is to display
     */
    public PreferencePresenter(PreferencePanelInterface pPanel,
                               DiscoveryResponseModel discoveryResponseModel){
        this.pPanel = pPanel;
        this.discoveryResponseModel = discoveryResponseModel;
    }


    @Override
    public void displayList() {
        this.userNames = this.discoveryResponseModel.getUserNames();
        viewModel.setUserName1(this.userNames.get(0));
        viewModel.setUserName2(this.userNames.get(1));
        //TODO: 15 usersName is planned to display, will fetch with user

        int FRAME_WIDTH = 414;
        int FRAME_HEIGHT = 736;
        this.pPanel.update(FRAME_WIDTH, FRAME_HEIGHT, viewModel);
    }
}
