package use_case_blocklist;
import entity.User;


public class BlockListManager implements BlockListInputBoundary {
    private final BlockListOutputBoundary blockListOutputBoundary;
    private User user;

    public BlockListManager(BlockListOutputBoundary blockListOutputBoundary, User user) {
        this.blockListOutputBoundary = blockListOutputBoundary;
        this.user = user;
    }

    @Override
    public void addBlockList(String username) {

        this.user.addBlockList(username);
    }

    @Override
    public void removeBlockList(String username) {

        this.user.removeBlockList(username);
    }

    @Override
    public boolean checkBlockList(String username) {
        blockListOutputBoundary.displayResult(username);
        return this.user.checkBlockList(username);
    }
}


