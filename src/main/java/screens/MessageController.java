package screens;

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
