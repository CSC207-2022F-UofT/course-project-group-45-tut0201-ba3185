package use_case_chatScreen_test;

import database.MessageDataManager;
import database.csvManager;
import org.junit.jupiter.api.*;
import use_case.message.*;

import java.io.File;
import java.util.*;



public class MessageInteractorUnitTest {
    /**
     * Unit tests for the MessageInteractor class, which test two situations,
     * one for initializing the screen for two user who never chat with each other,
     * one for updating the newest message when hit send button.*
     * -Test approach summary:
     * Tests are implemented by examining the if the desired output-data is generated
     * by checking the responseModel that put into presenter.
     * In order to avoid doing modification on database, data is stored in mms variable before each test, and is reloaded
     * after each test to be consistent.
     * The connection of each component of clean architecture is well tested, however, view is not included.
     */

    MessageManagers mms;
    MessageDataManager mdm = new MessageDataManager();
    @BeforeEach
    void save_database(){ //save the value of database before test, to avoid modification.
        this.mms = mdm.readMM();
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 141);
        userInfo.put("age", 142);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", true);
        userInfo.put("sexualOrientation", "female");
        manager.writeCurrentUser("sunny", "sunny", "sunny", location, userInfo, interestRank,
                "sport");
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

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
        File file = new File("src/main/java/database/MessageManagers.ser");
        file.delete();
    }
}
