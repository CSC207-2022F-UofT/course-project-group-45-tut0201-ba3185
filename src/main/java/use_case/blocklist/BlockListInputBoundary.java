package use_case.blocklist;

import entity.User;

public interface BlockListInputBoundary {
    void addBlockList(User user);

    void removeBlockList(User user);

    int checkBlockList(User user);
}
