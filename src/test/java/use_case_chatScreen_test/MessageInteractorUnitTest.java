package use_case_chatScreen_test;

import entity.ChatHistory;
import org.junit.Test;
import use_case_message.MessageManagers;
import org.junit.jupiter.api.Assertions;
import use_case_message.*;


class MessageInteractorUnitTest {
    @Test
    void create() {
        MessageOutputBoundary outputboundary = new MessageOutputBoundary() {
            @Override
            public MessageViewModel create(MessageResponseModel responseModel) {
                ChatHistory chatHistory = new ChatHistory("alyssa", "Jennifer");
                Assertions.assertEquals(chatHistory, responseModel.getChatHistory());
                return null;
            }
        };
        MessageManagerFactory factory = new MessageManagerFactory();
        MessageManagers mms = new MessageManagers();
        MessageInputBoundary interactor = new MessageInteractor(outputboundary,factory,mms);


        //MessageRequestModel inputData = new MessageRequestModel();
        //interactor.create(inputData);
    }
}
