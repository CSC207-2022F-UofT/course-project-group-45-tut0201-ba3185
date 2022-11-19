package use_case_frontpage;

import entity.User;

public class FrontPageRequestModel {
    private final User user;
    private final String target;

    public FrontPageRequestModel(User user, String target){
        this.user = user;
        this.target = target;
    }

    public User getUser() {
        return user;
    }

    public String getTarget() {
        return target;
    }
}
