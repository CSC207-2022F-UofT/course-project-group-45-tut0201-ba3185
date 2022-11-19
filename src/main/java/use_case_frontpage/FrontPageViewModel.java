package use_case_frontpage;

import java.util.ArrayList;

public class FrontPageViewModel {
    public ArrayList<String> targetIdList;

    public FrontPageViewModel(ArrayList<String> targetIdList){
        this.targetIdList = targetIdList;
    }

    public ArrayList<String> getMessages() {
        return targetIdList;
    }
}
