package use_case_message;

import java.util.ArrayList;

public class MessageViewModel {
    public ArrayList<String> Messages;

    public MessageViewModel(ArrayList<String> messages){
        this.Messages = messages;
    }

    public ArrayList<String> getMessages() {
        return Messages;
    }
}
