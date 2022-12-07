package entity;

import use_case_message.MessageManager;

import java.util.ArrayList;
import java.util.List;

public class MessageManagers {
    //The list of MessageManagers of the whole system. Store all the chat information.
    List<MessageManager> messageManagers;
    public MessageManagers(){
        messageManagers = new ArrayList<>();
    }

    public List<String> getUserChatted(String user){
        //Get all the usernames of the users who the input user has chatted with
        List<String> userChatted = new ArrayList<>();
        for (MessageManager mm : messageManagers){
            if (user.equals(mm.getUser1())){
                userChatted.add(mm.getUser2());
            }
            else if(user.equals(mm.getUser2())){
                userChatted.add(mm.getUser2());
            }
        }
        return userChatted;
    }

    public void addMM(MessageManager mm){
        messageManagers.add(mm);
    }

    public void removeMM(String user1, String user2){
        // Remove the stored MessageManager between the two users
        messageManagers.removeIf(mm -> (user1.equals(mm.getUser1()) && user2.equals(mm.getUser2())) ||
                (user1.equals(mm.getUser2()) && user2.equals(mm.getUser1())));
    }

    public MessageManager find(String user1, String user2){
        for (MessageManager mm : messageManagers){
            if ((user1.equals(mm.getUser1()) && user2.equals(mm.getUser2())) ||
                    (user1.equals(mm.getUser2()) && user2.equals(mm.getUser1()))){
                return mm;
            }
        }
        return null;
    }
}
