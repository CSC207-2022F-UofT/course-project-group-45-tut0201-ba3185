package use_case_frontpage_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case_frontpage.FrontPageInteractor;
import use_case_frontpage.FrontPageOutputBoundary;
import use_case_frontpage.FrontPageRequestModel;
import use_case_frontpage.FrontPageResponseModel;

/**
 * Unit tests for the FrontPageInteractor class, which tests the case when creating a front page with username button on it.
 * The connection of each component of clean architecture is well tested, however, view is not included.
 *
 */
public class FrontPageInteractorUnitTest {
    @Test
    void create(){
        FrontPageOutputBoundary frontPageOutputBoundary = new FrontPageOutputBoundary() {

            @Override
            public void create(FrontPageResponseModel responseModel) {
                Assertions.assertTrue(responseModel.getTargetUsers().contains("sunny"));
            }
        };
        FrontPageInteractor interactor = new FrontPageInteractor(frontPageOutputBoundary);
        FrontPageRequestModel requestModel = new FrontPageRequestModel("sunny");
        interactor.create(requestModel);
    }



    }




