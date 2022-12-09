package use_case_frontPage_test;

import database.MessageDataManager;
import database.csvManager;
import org.junit.jupiter.api.*;
import use_case_frontpage.FrontPageInteractor;
import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageRequestModel;
import use_case_message.MessageManagers;

import java.io.File;
import java.util.*;

/**
 * Unit tests for the FrontPageInteractor class, which tests the case when creating a front page with username button on it.
 * In this case, the current user doesn't chat with the targetuser, thus there shouldn't be any chatted user button of it,
 * by examining the output data we obtained in responseModel passed in presenter.
 * The ideal test design should also include the case that targetuser and current user have already chatted, an issue will be addressed
 * in repo and summary of testing method will be included.
 * The connection of each component of clean architecture is well tested, however, presenter, controller and view is not included.
 * it will also be addressed in repo
 */
public class FrontPageUnitTest {
    MessageManagers mms;
    MessageDataManager mdm = new MessageDataManager();
    @BeforeEach
    void save_database(){ //save the value of database before test, to avoid modification.
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
        this.mms = mdm.readMM();
    }

    @Test
    void create(){
        FrontPageOutputBoundary frontPageOutputBoundary = responseModel ->
                Assertions.assertFalse(responseModel.getTargetUsers().contains("Jenny"));
        FrontPageInteractor interactor = new FrontPageInteractor(frontPageOutputBoundary);
        FrontPageRequestModel requestModel = new FrontPageRequestModel();
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
