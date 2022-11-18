package use_case_blocklist;

import entity.User;

import java.util.ArrayList;

public interface BlockListOutputBoundary {

    void displayResult(String username);

    void displayBlockList(User user);
}
