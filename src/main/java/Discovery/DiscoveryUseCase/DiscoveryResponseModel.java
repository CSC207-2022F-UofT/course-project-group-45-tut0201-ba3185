package Discovery.DiscoveryUseCase;

import java.util.ArrayList;

public class DiscoveryResponseModel {
    private ArrayList<String> userNames;
    public DiscoveryResponseModel(){
        this.userNames = new ArrayList<>();
    }
    public void setUserNames(ArrayList<String> userNames){
        this.userNames = userNames;
    }
    public ArrayList<String> getUserNames(){
        return this.userNames;
    }
}
