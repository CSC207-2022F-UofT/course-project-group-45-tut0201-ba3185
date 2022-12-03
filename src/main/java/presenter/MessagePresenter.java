package presenter;

import screens.ChatScreenInterface;
import use_case_message.MessageOutputBoundary;
import use_case_message.MessageResponseModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The presenter that implements the OutputBoundary and updates the chat history on the chat page.
 */
public class MessagePresenter implements MessageOutputBoundary {
    final ChatScreenInterface cs;

    public MessagePresenter(ChatScreenInterface cs){
        this.cs = cs;
    }

    @Override
    public void create(MessageResponseModel responseModel) {
        /*
         * Show all the past chat history on the screen from the response model provided
         * by the interactor.
         */
        LinkedHashMap<String, String> content = responseModel.getChatHistory().getContent();

        ArrayList<String> messages = new ArrayList<>();
        for (Map.Entry<String, String> i : content.entrySet()) {
            String timeName = i.getKey();
            String msg = i.getValue();
            messages.add(timeName + ": " + msg);
        }
        for (String i : messages){
            cs.loadChat(i);
        } //load all chatHistory into UI
    }

    public void update(MessageResponseModel responseModel) {
        /*
         * Show the new message sent by one user on the screen from the response model provided
         * by the interactor.
         */
        LinkedHashMap<String, String> content = responseModel.getChatHistory().getContent();

        ArrayList<String> lKeys = new ArrayList<>(content.keySet());
        String timeName = lKeys.get(content.size() - 1);
        String msg = content.get(timeName);

        cs.loadChat(timeName + ": " + msg); //Load only the newest message in UI.
        }
    }
