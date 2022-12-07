package use_case_frontpage;

import database.MessageDataManager;
import database.csvManager;
import use_case_message.MessageManagers;
import use_case_signin_signup.UserRequestModel;

import java.util.List;

public class FrontPageInteractor implements FrontPageInputBoundary{
    /**
     * The interactor for front page that processes the request model to update the
     * prior targets (people who chatted with the user) and creates a response model
     * which is passed to the presenter to update UI.
     */
    final FrontPageOutputBoundary frontPageOutputBoundary;
    MessageDataManager messageDataManager = new MessageDataManager();
    MessageManagers messageManagers =  messageDataManager.readMM();

    public FrontPageInteractor(FrontPageOutputBoundary frontPageOutputBoundary) {
        this.frontPageOutputBoundary = frontPageOutputBoundary;
    }

    @Override
    public void create(FrontPageRequestModel requestModel) {
        try {
            csvManager manager = new csvManager();
            UserRequestModel model = manager.readCurrentUser();
            String user = model.getUsername();
            List<String> userTargetList = messageManagers.getUserChatted(user);

            FrontPageResponseModel responseModel = new FrontPageResponseModel(userTargetList);

            frontPageOutputBoundary.create(responseModel);
        }
        catch (NullPointerException exception){
            throw new RuntimeException("Current user not found. Please log in.");
        }
    }
}
