package entity;

public class Message{
    /**
     * The message that is sent by the user on the chat page.
     */
    private final String msg;

    public Message(String msg){
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
