package BlockListUserCaseTest;

import controller.BlockListController;
import entity.User;
import org.junit.Test;
import use_case_blocklist.BlockListManager;

public class BlockListManagerTest {

    @Test
    public void testadd(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.addBlockList(buser);
    }


    @Test
    public void testremove(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.removeBlockList(buser);
    }

    @Test
    public void testcheck(){
        BlockListManager blockListManager = new BlockListManager();
        User buser = new User("cam2", "cam2", "123");
        blockListManager.checkBlockList(buser);
    }
}
