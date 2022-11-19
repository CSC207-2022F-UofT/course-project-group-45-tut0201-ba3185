package use_case_message;
//use case layer

import entity.ChatHistory;

public class MessageManager {
    private final String user1;
    private final String user2;
    private ChatHistory history;

    MessageManager(String user1, String user2){
        this.user1 = user1;
        this.user2 = user2;
        this.history = new ChatHistory(user1, user2);
    }
    public void TriggerBlocklistManager(){

    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public void SaveChatHistory(String time, String user, String msg){
        if (user.equals(user1) || user.equals(user2)){
            history.content.put(time + ' ' + user, msg);
        }
    }

    public ChatHistory getChatHistory(){
        return history;
    }
}
