package entity;

import java.util.LinkedHashMap;

//entity layer
public class ChatHistory {
    private final String user1;
    private final String user2;
    public LinkedHashMap<String, String> content;

    public ChatHistory(String user1, String user2){
        this.user1 = user1;
        this.user2 = user2;
        this.content = new LinkedHashMap<String, String>();
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public LinkedHashMap<String, String> getContent() {
        return content;
    }
}
