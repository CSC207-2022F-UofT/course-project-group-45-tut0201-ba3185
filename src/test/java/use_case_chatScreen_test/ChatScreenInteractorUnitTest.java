package use_case_chatScreen_test;

import entity.ChatHistory;
import org.junit.Test;
import use_case_message.MessageManagers;
import entity.User;
import org.junit.jupiter.api.Assertions;
import use_case_message.*;

import static org.junit.jupiter.api.Assertions.assertSame;

class ChatScreenInteractorUnitTest {
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

        User user1 = new User("alyssa", "alyssa", "030508");
        MessageRequestModel inputData = new MessageRequestModel(user1, "Jennifer_XXX", "I miss you , jennifer");
        interactor.create(inputData);
    }
}
