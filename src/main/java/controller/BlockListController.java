package controller;
import entity.User;

import use_case_blocklist.BlockListInputBoundary;

public class BlockListController {
    private final BlockListInputBoundary blockListInoutBoundary;

    public BlockListController(BlockListInputBoundary blockListInoutBoundary) {
        this.blockListInoutBoundary = blockListInoutBoundary;
    }

    public void addBlockList(String username){  // trigger by UI
        blockListInoutBoundary.addBlockList(username);
    }
}
