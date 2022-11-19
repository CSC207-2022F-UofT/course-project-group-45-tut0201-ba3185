package use_case_frontpage;

import use_case_message.MessageResponseModel;
import use_case_message.MessageViewModel;

import java.util.ArrayList;

public interface FrontPageOutputBoundary {
    FrontPageViewModel create(FrontPageResponseModel responseModel);
}
