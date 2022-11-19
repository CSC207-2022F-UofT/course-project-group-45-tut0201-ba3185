package screens;

import entity.User;
import use_case_message.MessageInputBoundary;
import use_case_message.MessageRequestModel;
import use_case_message.MessageResponseModel;
import use_case_message.MessageViewModel;

public class MessageController {
    public MessageRequestModel create(User user, String target){
        MessageRequestModel requestModel = new MessageRequestModel(user, target);
        return requestModel;
    }

    public MessageRequestModel create(User user, String target, String msgValue){
        MessageRequestModel requestModel = new MessageRequestModel(user, target, msgValue);
        return requestModel;
    }
}
