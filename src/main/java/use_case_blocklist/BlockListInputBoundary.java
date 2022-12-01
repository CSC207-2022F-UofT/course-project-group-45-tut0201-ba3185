package use_case_blocklist;

import entity.User;

public interface BlockListInputBoundary {
    void addBlockList(User user);

    void removeBlockList(User user);

    boolean checkBlockList(User user);
}
