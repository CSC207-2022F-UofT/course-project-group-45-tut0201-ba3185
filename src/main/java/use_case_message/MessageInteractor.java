package use_case_message;

import database.csvManager;
import presenter.MessagePresenter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MessageInteractor implements MessageInputBoundary {
    /**
     * The interactor for chat page that processes the request model to update the
     * chat history and creates a response model which is passed to the presenter to
     * update the view.
     */
    final MessageOutputBoundary messageOutputBoundary;
    final MessageManagerFactory chatFactory;
    MessageManagers messageManagers;

    public MessageInteractor(MessageOutputBoundary messageOutputBoundary,
                             MessageManagerFactory chatFactory, MessageManagers messageManagers) {
        this.messageOutputBoundary = messageOutputBoundary;
        this.chatFactory = chatFactory;
        this.messageManagers = messageManagers;
    }

    @Override
    public void create(MessageRequestModel requestModel) {
        String user1 = csvManager.readCurrentUser().toString();
        String user2 = requestModel.getTarget();
        MessageManager mm;

        // get the prior MessageManager or create a new one if there's no prior one
        if (messageManagers.find(user1, user2) != null){
            mm = messageManagers.find(user1, user2);
        }
        else{
            mm = chatFactory.create(user1, user2);
        }

        SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String msg = requestModel.getMsg();
        if(msg != null){ // if the message is not null, update it onto the screen
            mm.SaveChatHistory(now.format(timestamp), user1, msg); //record the new message
            MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());

            messageOutputBoundary.update(messageResponseModel);
        }

        // if the message is null, load all chat history
        MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());
        messageOutputBoundary.create(messageResponseModel);
    }
}
