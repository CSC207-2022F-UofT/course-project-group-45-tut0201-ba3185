package use_case_chatScreen_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_message.*;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class MessageInteractorUnitTest {

    @Test
    void create(){
        MessageManagerFactory chatFactory = new MessageManagerFactory();
        MessageOutputBoundary messageOutputBoundary = new MessageOutputBoundary() {
            @Override
            public void create(MessageResponseModel responseModel) {
                Assertions.assertEquals(0, responseModel.getChatHistory().getContent().size());
            }

            @Override
            public void update(MessageResponseModel responseModel) {

            }
        };
        MessageRequestModel requestModel = new MessageRequestModel("Jenny");
        MessageInteractor interactor = new MessageInteractor(messageOutputBoundary, chatFactory);
        interactor.create(requestModel);
    }
    @Test
    void update(){
        MessageManagerFactory chatFactory = new MessageManagerFactory();
        MessageOutputBoundary messageOutputBoundary = new MessageOutputBoundary() {
            @Override
            public void create(MessageResponseModel responseModel) {
                Assertions.assertTrue(responseModel.getChatHistory().getContent().containsValue("u should stop dating if u r married"));
            }

            @Override
            public void update(MessageResponseModel responseModel) {

            }
        };
        MessageRequestModel requestModel = new MessageRequestModel("Jenny","u should stop dating if u r married");
        MessageInteractor interactor = new MessageInteractor(messageOutputBoundary, chatFactory);
        interactor.create(requestModel);
    }
}
