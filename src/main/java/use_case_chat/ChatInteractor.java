package use_case_chat;

import entity.MessageManagers;
import presenter.MessagePresenter;
import java.time.format.DateTimeFormatter;

public class ChatInteractor implements ChatInputBoundary{
    final MessagePresenter messagePresenter;
    final MessageManagerFactory chatFactory;
    MessageManagers messageManagers;

    public ChatInteractor(MessagePresenter messagePresenter,
                                  MessageManagerFactory chatFactory, MessageManagers messageManagers) {
        this.messagePresenter = messagePresenter;
        this.chatFactory = chatFactory;
        this.messageManagers = messageManagers;
    }

    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {
        String user1 = requestModel.getUser();
        String user2 = requestModel.getTarget();
        MessageManager mm;

        // get the prior MessageManager or create a new one if there's no prior one
        if (messageManagers.find(user1, user2) != null){
            mm = messageManagers.find(user1, user2);
        }
        else{
            mm = chatFactory.create(user1, user2);
        }

        String now = String.format(String.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String msg = requestModel.getMsg();
        mm.SaveChatHistory(now, user1, msg); //record the new message

        MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());

        return messagePresenter.prepareSuccessView(messageResponseModel);
    }
}
