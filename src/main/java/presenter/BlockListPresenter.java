package presenter;

import entity.User;
import use_case_blocklist.BlockListOutputBoundary;

public class BlockListPresenter implements BlockListOutputBoundary {


    @Override
    public void displayBlockList(User User) {
        System.out.println(User.getBlockList());
    }


    @Override
    public void displayResult(String username) {
        System.out.println(username);
    }
}
