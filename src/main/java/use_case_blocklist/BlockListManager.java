package use_case_blocklist;
import entity.User;


public class BlockListManager implements BlockListInputBoundary {
    private final BlockListOutputBoundary BlockListOutputBoundary;
    private User user;

    public BlockListManager(BlockListOutputBoundary BlockListOutputBoundary, User user) {
        this.BlockListOutputBoundary = BlockListOutputBoundary;
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

    public void checkBlockList(String username){
        this.user.checkBlockList(username);
        BlockListOutputBoundary.displayResult(username);
        }
    }


