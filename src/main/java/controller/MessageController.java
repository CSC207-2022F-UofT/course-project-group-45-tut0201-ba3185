package controller;

import use_case_message.MessageRequestModel;

public class MessageController {
    /**
     * The controller of message that converts the request of sending a new message
     * or loading chat history into a request model and passes it to the interactor.
     *
     * @param target the target user who the user wants to talk to
     * @return the request model that will be passed to the interactor through
     * input boundary
     */
    public MessageRequestModel create(String target){
        return new MessageRequestModel(target);
    }

    public MessageRequestModel create(String target, String msgValue){
        return new MessageRequestModel(target, msgValue);
    }
}