package screens;

import presenter.MessagePresenter;
import use_case_chat.MessageResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//interface adapter layer
public class ChatOutputBoundary implements MessagePresenter {

    private final LinkedHashMap<String, String> content;

    public ChatOutputBoundary (MessageResponseModel response){
        content = response.getChatHistory().getContent();
    }

    public JLabel generateResponseMsg() {
        if(){//the button is clicked
            ArrayList<String> lKeys = new ArrayList<String>(content.keySet());
            String timeName = lKeys.get(content.size() - 1);
            String msg = content.get(timeName);
            JLabel jlabel = new JLabel(timeName + ": " + msg);
            jlabel.setFont(new Font("Verdana", 1, 20));
            return jlabel;
        }
        for (Map.Entry<String, String> i : content.entrySet()) {
            String timeName = i.getKey();
            String msg = i.getValue();
            JLabel jlabel = new JLabel(timeName + ": " + msg);
            jlabel.setFont(new Font("Verdana", 1, 20));

        }
//        JLabel jlabel = new JLabel(timeName + ": " + msg);
//        jlabel.setFont(new Font("Verdana", 1, 20));
//        return jlabel;
    }// in order to "write" our message on display box, we can generate JLabel to write it on.

    @Override
    public MessageResponseModel prepareSuccessView(MessageResponseModel response){}
}
