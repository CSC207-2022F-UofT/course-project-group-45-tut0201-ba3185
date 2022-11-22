package presenter;

// Use case layer

import use_case_message.MessageOutputBoundary;
import use_case_message.MessageResponseModel;
import use_case_message.MessageViewModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The presenter that implements the OutputBoundary to return the view model
 * to UI to show the user their updated chatting information on the chat page.
 */
public class MessagePresenter implements MessageOutputBoundary {
    private final boolean clicked;

    public MessagePresenter(boolean clicked){
        this.clicked = clicked;
    }

    @Override
    public MessageViewModel create(MessageResponseModel responseModel) {
        /**
         * Create the view model that will be passed to the view from the response model provided
         * by the interactor. The view model contains all the chat history that the two users had
         * if one of the users just clicked into the page (to load history) and contains only the
         * new message sent by the user if the user is staying in the page.
         */
        LinkedHashMap<String, String> content= responseModel.getChatHistory().getContent();
        if(clicked){
            ArrayList<String> messages = new ArrayList<>();
            for (Map.Entry<String, String> i : content.entrySet()){
                String timeName = i.getKey();
                String msg = i.getValue();
                messages.add(timeName + ": " + msg);
            }                                          //this is when we click button on Frontpage, then we load chathistory
            return new MessageViewModel(messages);
        }
        else{
            ArrayList<String> lKeys = new ArrayList<>(content.keySet());
            String timeName = lKeys.get(content.size() - 1);
            String msg = content.get(timeName);
            ArrayList<String> messages = new ArrayList<>();
            messages.add(timeName + ": " + msg);
            return new MessageViewModel(messages);   //this is when we click sendButton on ChatScreen.
        }
    }
}