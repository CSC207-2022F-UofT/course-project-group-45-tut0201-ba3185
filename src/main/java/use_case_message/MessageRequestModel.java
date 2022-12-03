package use_case_message;

public class MessageRequestModel {
    /**
     * The request model generated by the controller to be passed to the interactor
     * to be processed.
     * Contain the target who the current user wants to chat with and the message sent by the user
     */
    private final String target;
    private final String msg;

    public MessageRequestModel(String target){
        this.target = target;
        this.msg = null;
    }

    public MessageRequestModel(String target, Object msg){
        this.target = target;
        if(msg instanceof String){
            this.msg = (String) msg;
        }
        else {
            this.msg = null;
        }
    }

    public String getTarget() {
        return target;
    }

    public String getMsg() {
        return msg;
    }
}
