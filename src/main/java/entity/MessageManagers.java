package entity;

import use_case_chat.MessageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageManagers {
    List<MessageManager> MessageManagers;
    public MessageManagers(){
        MessageManagers = new ArrayList<>();
    }

    public List<MessageManager> getMMs(){
        return MessageManagers;
    }

    public void addMM(MessageManager mm){
        MessageManagers.add(mm);
    }

    public MessageManager find(String user1, String user2){
        for (MessageManager mm : MessageManagers){
            if ((mm.getUser1() == user1 && mm.getUser2() == user2) ||
                    (mm.getUser2() == user1 && mm.getUser1() == user2)){
                return mm;
            }
        }
        return null;
    }
}
