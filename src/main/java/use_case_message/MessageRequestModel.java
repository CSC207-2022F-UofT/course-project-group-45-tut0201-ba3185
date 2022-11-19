package use_case_message;

import entity.User;

public class MessageRequestModel {
    private final User user;
    private final String target;
    private final String msg;

    public MessageRequestModel(User user, String target){
        this.user = user;
        this.target = target;
        this.msg = null;
    }

    public MessageRequestModel(User user, String target, Object msg){
        this.user = user;
        this.target = target;
        if(msg instanceof String){
            this.msg = (String) msg;
        }
        else {
            this.msg = null;
        }
    }

    public User getUser() {
        return user;
    }

    public String getUserString() {
        return user.getUsername();
    }

    public String getTarget() {
        return target;
    }

    public String getMsg() {
        return msg;
    }
}
