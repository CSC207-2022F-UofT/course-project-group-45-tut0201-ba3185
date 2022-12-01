package presenter;

import entity.User;
import use_case_blocklist.BlockListOutputBoundary;

public class BlockListPresenter implements BlockListOutputBoundary {


    @Override
    public String displayResult(User user) {
        //something connect to UI
        return null;
    }
}
