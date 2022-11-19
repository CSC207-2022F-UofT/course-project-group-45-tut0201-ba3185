package use_case_message;

import entity.MessageManagers;
import presenter.MessagePresenter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MessageInteractor implements MessageInputBoundary {
    final MessagePresenter messagePresenter;
    final MessageManagerFactory chatFactory;
    MessageManagers messageManagers;

    public MessageInteractor(MessagePresenter messagePresenter,
                             MessageManagerFactory chatFactory, MessageManagers messageManagers) {
        this.messagePresenter = messagePresenter;
        this.chatFactory = chatFactory;
        this.messageManagers = messageManagers;
    }

    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {
        String user1 = requestModel.getUserString();
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
        if(msg != null){
            mm.SaveChatHistory(now.format(timestamp), user1, msg); //record the new message
        }

        MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());

        return messageResponseModel;
    }
}
