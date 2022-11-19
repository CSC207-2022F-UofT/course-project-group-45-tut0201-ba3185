package use_case_frontpage;

import entity.User;
import presenter.FrontPagePresenter;
import java.util.ArrayList;

public class FrontPageInteractor implements FrontPageInputBoundary{
    final FrontPagePresenter frontPagePresenter;
    User user;

    public FrontPageInteractor(FrontPagePresenter frontPagePresenter, User user) {
        this.frontPagePresenter = frontPagePresenter;
        this.user = user;
    }

    @Override
    public FrontPageResponseModel create(FrontPageRequestModel requestModel) {
        User user = requestModel.getUser();
        String target = requestModel.getTarget();

        ArrayList<String> userTargetList = user.getUserChatted();

        // add the target in user if it is a new target
        if (!userTargetList.contains(target)){
            user.addUserChatted(target);
        }

        FrontPageResponseModel responseModel = new FrontPageResponseModel(user.getUserChatted());

        return responseModel;
    }
}
