package Discovery.DiscoveryController;
import Discovery.DiscoveryUseCase.PreferenceFinderInputBoundary;
import User.User;

import Discovery.DiscoveryUseCase.PreferenceFinder;

import java.util.ArrayList;

public class PreferenceFinderController {
    private PreferenceFinderInputBoundary preferenceFinder;

    public void generateRecommendation(){
        preferenceFinder.recommendListGenerator();
    }
}
