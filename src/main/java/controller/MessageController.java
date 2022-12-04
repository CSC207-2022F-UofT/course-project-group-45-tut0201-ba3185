package controller;

import use_case_message.MessageInputBoundary;
import use_case_message.MessageRequestModel;

public class MessageController {
    /**
     * The controller of message that converts the request of sending a new message
     * or loading chat history into a request model and passes it to the interactor
     *
     */
    final MessageInputBoundary messageInputBoundary;
    public MessageController(MessageInputBoundary messageInputBoundary){
        this.messageInputBoundary = messageInputBoundary;
    }
    public MessageRequestModel create(String target){
        MessageRequestModel messageRequestModel = new MessageRequestModel(target)
        this.messageInputBoundary.create(messageRequestModel);
    }

    public MessageRequestModel create(String target, String msgValue){
        MessageRequestModel messageRequestModel = new MessageRequestModel(target, msgValue)
        this.messageInputBoundary.create(messageRequestModel);
    }
}