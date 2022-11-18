package use_case_blocklist;
import entity.User;

public interface BlockListInputBoundary {
    void addBlockList(String username);

    void removeBlockList(String username);

    void checkBlockList(String username);
}
