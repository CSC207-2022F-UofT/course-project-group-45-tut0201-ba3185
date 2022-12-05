package BlockListUserCaseTest;

import controller.BlockListController;
import entity.User;
import use_case_blocklist.BlockListManager;

public class BlockListManagerTest {

    @org.junit.Test
    public void add(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.addBlockList(buser);
    }


    @org.junit.Test
    public void remove(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.removeBlockList(buser);
    }
}
