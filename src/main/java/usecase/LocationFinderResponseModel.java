package usecase;

import java.util.ArrayList;

public class LocationFinderResponseModel {
    ArrayList<String> recommendList;

    public LocationFinderResponseModel(ArrayList<String> recommendList){
        this.recommendList = recommendList;
    }
    public ArrayList<String> recommendListGenerator(){

        return recommendList;
    }
}
