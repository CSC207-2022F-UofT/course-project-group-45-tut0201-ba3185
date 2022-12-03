package use_case_frontpage;

import database.csvManager;
import entity.User;
import java.util.ArrayList;

public class FrontPageInteractor implements FrontPageInputBoundary{
    /**
     * The interactor for front page that processes the request model to update the
     * prior targets (people who chatted with the user) and creates a response model
     * which is passed to the presenter to update UI.
     */
    final FrontPageOutputBoundary frontPageOutputBoundary;

    public FrontPageInteractor(FrontPageOutputBoundary frontPageOutputBoundary) {
        this.frontPageOutputBoundary = frontPageOutputBoundary;
    }

    @Override
    public void create(FrontPageRequestModel requestModel) {
        User user = csvManager.readCurrentUser();
        String target = requestModel.getTarget();

        ArrayList<String> userTargetList = user.getUserChatted();

        // add the target in user if it is a new target
        if (!userTargetList.contains(target)){
            user.addUserChatted(target);
        }

        FrontPageResponseModel responseModel = new FrontPageResponseModel(user.getUserChatted());

        frontPageOutputBoundary.create(responseModel);
    }
}
