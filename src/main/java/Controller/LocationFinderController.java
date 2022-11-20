package Controller;
import usecase.LocationFinder;
import usecase.LocationFinderInputBoundary;

public class LocationFinderController {
    private LocationFinderInputBoundary locationFinder;

    public LocationFinderController(LocationFinderInputBoundary locationFinder){
        this.locationFinder = locationFinder;
    }
    public void generateRecommendation(){

        locationFinder.recommendListGenerator();
    }
}
