package use_case_chatScreen_test;

import database.csvManager;
import entity.ChatHistory;
import org.junit.Test;
import presenter.MessagePresenter;
import use_case_message.MessageManagers;
import org.junit.jupiter.api.Assertions;
import use_case_message.*;


class MessageInteractorUnitTest {
    MessageOutputBoundary messageOutputBoundary;
    MessageManagers messageManagers;
    MessageManagerFactory chatFactory;
    @Test
    void updateChatScreen(){
        this.chatFactory = new MessageManagerFactory();
        //this.messageManagers = MainFrame.messageManagers;
        this.messageOutputBoundary = new MessageOutputBoundary() {
            @Override
            public void create(MessageResponseModel responseModel) {
                //messages.
            }

            @Override
            public void update(MessageResponseModel responseModel) {

            }
        };
        MessageInputBoundary interactor = new MessageInteractor();

        MessageRequestModel inputData = new MessageRequestModel("sunny", "Did you see the giant dinosaur in Robarts");

        interactor.create(inputData);
    }

    void loadChatScreen(){

    }
}