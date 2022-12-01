package screens;

<<<<<<< HEAD
import entity.User;
import use_case_message.MessageInputBoundary;
import use_case_message.MessageRequestModel;
import use_case_message.MessageResponseModel;
import use_case_message.MessageViewModel;

public class MessageController {
    /**
     * The controller of message that converts the request of sending a new message
     * or loading chat history into a request model and passes it to the interactor.
     *
     * @param user the user who starts the conversation
     * @param target the target user who the user wants to talk to
     * @return the request model that will be passed to the interactor through
     * input boundary
     */
    public MessageRequestModel create(User user, String target){
        MessageRequestModel requestModel = new MessageRequestModel(user, target);
        return requestModel;
    }

    public MessageRequestModel create(User user, String target, String msgValue){
        MessageRequestModel requestModel = new MessageRequestModel(user, target, msgValue);
        return requestModel;
    }
}
=======
import entity.Message;
import use_case_chat.ChatInputBoundary;
import use_case_chat.MessageRequestModel;
import use_case_chat.MessageResponseModel;

public class MessageController {
    ChatInputBoundary chatInput;
    String targetUserid;
    String msgValue;
    public MessageController(ChatInputBoundary chatInputBoundary, String msgValue) {
        this.chatInput = chatInputBoundary;
        this.msgValue = msgValue;
    }

    public MessageRequestModel createRM(String target, String msgValue){
        MessageRequestModel requestModel = new MessageRequestModel(target, msgValue);
        return requestModel;
    }

    MessageResponseModel create(String target, Message message) {
        MessageRequestModel requestModel = new MessageRequestModel(target, message);
        return chatInput.create(requestModel);
    } //I am confused... why we need this?问Jennifer

    }
>>>>>>> main
