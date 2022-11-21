package use_case_blocklist;

public interface BlockListInputBoundary {
    void addBlockList(String username);

    void removeBlockList(String username);

    boolean checkBlockList(String username);
}
