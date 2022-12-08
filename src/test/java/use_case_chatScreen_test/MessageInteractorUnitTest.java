package use_case_chatScreen_test;

import database.MessageDataManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_message.*;



public class MessageInteractorUnitTest {
    /**
     * Unit tests for the MessageInteractor class, which test two situations,
     * one for initializing the screen for two user who never chat with each other,
     * one for updating the newest message when hit send button.*
     * -Test approach summary:
     * Tests are implemented by examining the if the desired outputdata is generated
     * by checking the responseModel that put into presenter.
     * In order to avoid doing modificaiton on database, data is stored in mms variable before each test, and is reloaded
     * after each test to be consistent.
     * The connection of each component of clean architecture is well tested, however, view is not included.
     */

    MessageManagers mms;
    MessageDataManager mdm = new MessageDataManager();
    @BeforeEach
    void save_database(){ //save the value of database before test, to avoid modification.
        this.mms = mdm.readMM();
    }


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
                Assertions.fail("Use case shouldn't execute this branch");
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
                Assertions.fail("Use case shouldn't execute this branch");

            }

            @Override
            public void update(MessageResponseModel responseModel) {
                Assertions.assertTrue(responseModel.getChatHistory().getContent().containsValue("u should stop dating if u r married"));

            }
        };
        MessageRequestModel requestModel = new MessageRequestModel("Jenny","u should stop dating if u r married");
        MessageInteractor interactor = new MessageInteractor(messageOutputBoundary, chatFactory);
        interactor.create(requestModel);
    }
    @AfterEach
    void teardown(){
        mdm.writeMM(mms);
    }
}
