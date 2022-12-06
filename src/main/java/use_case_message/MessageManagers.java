package use_case_message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageManagers implements Serializable {
    /**
     * The use case that stores all the MessageManagers in the program
     */
    List<MessageManager> MessageManagers; //MessageManager is use case??
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
            if ((Objects.equals(mm.getUser1(), user1) && Objects.equals(mm.getUser2(), user2)) ||
                    (Objects.equals(mm.getUser2(), user1) && Objects.equals(mm.getUser1(), user2))){
                return mm;
            }
        }
        return null;
    }
}
