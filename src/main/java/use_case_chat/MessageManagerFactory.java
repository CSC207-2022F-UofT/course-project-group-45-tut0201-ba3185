package use_case_chat;

public class MessageManagerFactory {
    public MessageManager create(String user1, String user2){
        return new MessageManager(user1, user2);
    }
}
