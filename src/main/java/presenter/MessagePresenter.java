package presenter;

// Use case layer

import use_case_message.MessageOutputBoundary;
import use_case_message.MessageResponseModel;
import use_case_message.MessageViewModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessagePresenter implements MessageOutputBoundary {
    private final boolean clicked;

    public MessagePresenter(boolean clicked){
        this.clicked = clicked;
    }

    @Override
    public MessageViewModel create(MessageResponseModel responseModel) {
        LinkedHashMap<String, String> content= responseModel.getChatHistory().getContent();
        if(clicked){
            ArrayList<String> messages = new ArrayList<>();
            for (Map.Entry<String, String> i : content.entrySet()){
                String timeName = i.getKey();
                String msg = i.getValue();
                messages.add(timeName + ": " + msg);
            }
            return new MessageViewModel(messages);
        }
        else{
            ArrayList<String> lKeys = new ArrayList<>(content.keySet());
            String timeName = lKeys.get(content.size() - 1);
            String msg = content.get(timeName);
            ArrayList<String> messages = new ArrayList<>();
            messages.add(timeName + ": " + msg);
            return new MessageViewModel(messages);
        }
    }

    //    public JLabel generateResponseMsg(boolean buttonClick, ) {
//        if(buttonClick){//the user button on front page is clicked.
//            for (Map.Entry<String, String> i : content.entrySet()) {
//                String timeName = i.getKey();
//                String msg = i.getValue();
//                JLabel jlabel = new JLabel(timeName + ": " + msg);
//                jlabel.setFont(new Font("Verdana", 1, 20));
//                // add message
//                // frontpage button clicked = false
//            }
//        }
//        else {
//            ArrayList<String> lKeys = new ArrayList<String>(content.keySet());
//            String timeName = lKeys.get(content.size() - 1);
//            String msg = content.get(timeName);
//            JLabel jlabel = new JLabel(timeName + ": " + msg);
//            jlabel.setFont(new Font("Verdana", 1, 20));
//            return jlabel;
//        }
//    }// else case is for updating the display box after clicking "send button"

//    @Override
//    public MessageResponseModel prepareSuccessView(MessageResponseModel response){}
}