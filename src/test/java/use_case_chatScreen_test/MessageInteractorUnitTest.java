package use_case_chatScreen_test;


import org.junit.jupiter.api.Test;

import use_case_message.MessageManagers;
import org.junit.jupiter.api.Assertions;
import use_case_message.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MessageInteractor class, which tests all cases, either initializing a new screen or updating newest sent message.
 * The connection of each component of clean architecture is well tested, however, view is not included.
 *
 */
public class MessageInteractorUnitTest {
    MessageOutputBoundary messageOutputBoundary;
    MessageManagers messageManagers;
    MessageManagerFactory chatFactory;

    @Test
    public void createChatScreen(){  //the case when two users haven't chatted before, chatHistory doesn't have contents inside.
        this.chatFactory = new MessageManagerFactory();
        this.messageManagers = new MessageManagers();
        this.messageOutputBoundary = new MessageOutputBoundary() {
            @Override
            public void create(MessageResponseModel responseModel) {
                assertEquals(0, responseModel.getChatHistory().getContent().size());

            }

            @Override
            public void update(MessageResponseModel responseModel) {
                fail("Use case failure is unexpected.");
            }
        };

        MessageRequestModel inputData = new MessageRequestModel("sunny");
        MessageInputBoundary interactor = new MessageInteractor(messageOutputBoundary, chatFactory, messageManagers);
        interactor.create(inputData);
    }

    @Test
    public void updateChatScreen(){ //the case when one user sent a message.
        this.chatFactory = new MessageManagerFactory();
        this.messageManagers = new MessageManagers();
        this.messageOutputBoundary = new MessageOutputBoundary() {
            @Override
            public void create(MessageResponseModel responseModel) {
                fail("Use case failure is unexpected.");

            }

            @Override
            public void update(MessageResponseModel responseModel) {
                Assertions.assertTrue(responseModel.getChatHistory().getContent().containsValue("Did you see the giant dinosaur in Robarts"));
            }
        };

        MessageRequestModel inputData = new MessageRequestModel("sunny", "Did you see the giant dinosaur in Robarts");
        MessageInputBoundary interactor = new MessageInteractor(messageOutputBoundary, chatFactory, messageManagers);
        interactor.create(inputData);
    }



}