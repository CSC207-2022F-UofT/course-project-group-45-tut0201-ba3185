package use_case_chat;

import entity.Message;

public class MessageRequestModel {
    private final String user;
    private final String target;
    private final String msg;

    public MessageRequestModel(String user, String target, Object msg){
        this.user = user;
        this.target = target;
        if(msg instanceof String){
            this.msg = (String) msg;
        }
        else {
            this.msg = null;
        }
    }

    public String getUser() {
        return user;
    }

    public String getTarget() {
        return target;
    }

    public String getMsg() {
        return msg;
    }
}
