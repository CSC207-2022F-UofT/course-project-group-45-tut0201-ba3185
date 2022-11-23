package usecase;

import java.util.ArrayList;

public class LocationFinderResponseModel {
    public ArrayList<String> usernames;
    public void setRecommendList(ArrayList<String> usernames){
        this.usernames = usernames;
    }
    public ArrayList<String> getRecommendList(){
        ArrayList<String> recommendList = new ArrayList<>();
        for(int i=0; i<15; i++){
            recommendList.add(usernames.get(i));
        }
        return recommendList;
    }
}
