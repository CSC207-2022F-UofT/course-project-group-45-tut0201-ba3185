package use_case_frontpage;

import java.util.ArrayList;

public class FrontPageResponseModel {
    ArrayList<String> TargetUsers;

    public FrontPageResponseModel(ArrayList<String> targetUsers){
        this.TargetUsers = targetUsers;
    }

    public ArrayList<String> getTargetUsers(){
        return TargetUsers;
    }
}
