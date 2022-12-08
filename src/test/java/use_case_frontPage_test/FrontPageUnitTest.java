package use_case_frontPage_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case_frontpage.FrontPageInteractor;
import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageRequestModel;
import use_case_frontpage.FrontPageResponseModel;

/**
 * Unit tests for the FrontPageInteractor class, which tests the case when creating a front page with username button on it.
 * In this case, the current user doesn't chat with the targetuser, thus there shouldn't be any chatted user button of it,
 * by examining the output data we obtained in responseModel passed in presenter.
 * Since this test doesn't involve in modifying database, there is no use to load and reload before and after test execution.
 * The ideal test design should also include the case that targetuser and current user have already chatted, an issue will be addressed
 * in repo and summary of testing method will be included.
 * The connection of each component of clean architecture is well tested, however, presenter, controller and view is not included.
 *
 */
public class FrontPageUnitTest {
    @Test
    void create(){
        FrontPageOutputBoundary frontPageOutputBoundary = new FrontPageOutputBoundary() {
            @Override
            public void create(FrontPageResponseModel responseModel) {
                Assertions.assertFalse(responseModel.getTargetUsers().contains("Jenny"));
            }
        };
        FrontPageInteractor interactor = new FrontPageInteractor(frontPageOutputBoundary);
        FrontPageRequestModel requestModel = new FrontPageRequestModel();
        interactor.create(requestModel);
    }





}
