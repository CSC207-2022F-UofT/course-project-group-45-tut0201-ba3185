package use_case_blocklist;

import controller.BlockListController;
import database.csvManager;
import entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

public class BlockListManagerTest {

    private User buser;

    @BeforeEach
    public void testUser(){
        buser = new User("cam2", "cam2", "123");
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(14.5,14.5));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 141);
        userInfo.put("age", 142);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", true);
        userInfo.put("sexualOrientation", "female");
        manager.writeCurrentUser("sunny", "sunny", "sunny", location, userInfo, interestRank,
                "sport");
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

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
        File blockList = new File("src/main/java/database/blockList.csv");
        blockList.delete();
    }
}
