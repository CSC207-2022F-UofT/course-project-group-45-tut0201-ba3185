package controller;

import use_case.message.MessageInputBoundary;
import use_case.message.MessageRequestModel;

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
    public void create(String target){
        MessageRequestModel messageRequestModel = new MessageRequestModel(target);
        this.messageInputBoundary.create(messageRequestModel);
    }

    public void create(String target, String msgValue){
        MessageRequestModel messageRequestModel = new MessageRequestModel(target, msgValue);
        this.messageInputBoundary.create(messageRequestModel);
    }
}