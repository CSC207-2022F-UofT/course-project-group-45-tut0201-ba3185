package BlockListUseCaseTest;
import entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlockListManagerTest {
    User user1;
    User user2;
    User user3;

    @Before
    public void Setup(){
        User user1 = new User("cam", "cam", "123");
        User user2 = new User("aly", "aly", "123");
        User user3 = new User("amb", "amb", "123");
        //user1 add user2 and user3 to blocklist
        user1.addBlockList(user2.getUsername());
        user1.addBlockList(user3.getUsername());

    }
    @After
    public void tearDown() throws Exception {
        user1 = null;
        user2 = null;
        user3 = null;
    }

    @Test
    public void testRemoveFromBlockList() {

        boolean expected = false;
        user1.removeBlockList(user2.getUsername());
        boolean actual = user1.checkBlockList(user2.getUsername());
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFromBlockList() {
        ArrayList<String> blockList = new ArrayList<>();
        User user4 = new User("m", "m", "3");

        user1.addBlockList(user4.getUsername());
        blockList.add(user2.getUsername());
        blockList.add(user3.getUsername());
        blockList.add(user4.getUsername());

        ArrayList<String> actual = user1.getBlockList();
        assertEquals(blockList, actual);
    }

}

