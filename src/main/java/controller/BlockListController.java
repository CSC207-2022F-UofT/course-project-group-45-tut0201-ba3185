package controller;
import entity.User;

import use_case.blocklist.BlockListInputBoundary;

public class BlockListController {
    private final BlockListInputBoundary blockListInoutBoundary;

    public BlockListController(BlockListInputBoundary blockListInoutBoundary) {
        this.blockListInoutBoundary = blockListInoutBoundary;
    }

    public void addBlockList(User user){  // trigger by UI
        blockListInoutBoundary.addBlockList(user);
    }

    public void removeBlockList(User user){  // trigger by UI
        blockListInoutBoundary.removeBlockList(user);
    }


}
