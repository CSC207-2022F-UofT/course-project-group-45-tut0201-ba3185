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
        MessageRequestModel requestModel = new MessageRequestModel(target);
        return requestModel;
    }

    public MessageRequestModel create(String target, String msgValue){
        MessageRequestModel requestModel = new MessageRequestModel(target, msgValue);
        return requestModel;
    }
}