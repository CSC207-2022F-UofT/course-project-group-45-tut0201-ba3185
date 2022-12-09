package use_case_blocklist;

import controller.BlockListController;
import entity.User;
import org.junit.jupiter.api.Test;

public class BlockListManagerTest {

    @Test
    public void testadd(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.addBlockList(buser);
    }


    @org.junit.jupiter.api.Test
    public void testremove(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.removeBlockList(buser);
    }

    @org.junit.jupiter.api.Test
    public void testcheck(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        blockListManager.checkBlockList(buser);
    }
}
