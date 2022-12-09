package use_case_blocklist;

import controller.BlockListController;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockListManagerTest {

    private User buser;

    @BeforeEach
    public void testUser(){
        buser = new User("cam2", "cam2", "123");
    }

    @Test
    public void testadd(){
        BlockListManager blockListManager = new BlockListManager();
        buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.addBlockList(buser);
    }


    @Test
    public void testremove(){
        BlockListManager blockListManager = new BlockListManager();
        buser = new User("cam2", "cam2", "123");
        BlockListController controller = new BlockListController(blockListManager);
        controller.removeBlockList(buser);
    }

    @Test
    public void testcheck(){
        BlockListManager blockListManager = new BlockListManager();
        buser = new User("cam2", "cam2", "123");
        blockListManager.checkBlockList(buser);
    }
}
