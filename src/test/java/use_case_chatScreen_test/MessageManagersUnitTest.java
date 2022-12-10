package use_case_chatScreen_test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.message.MessageManager;
import use_case.message.MessageManagerFactory;
import use_case.message.MessageManagers;

import static org.junit.jupiter.api.Assertions.assertSame;
/**
 * Unit tests for the MessageManagers class, which tests the addMM,find, getUserChatted methods for most cases.
 *
 */
public class MessageManagersUnitTest {

    @Test
    void addMessageManagerTest() {
        MessageManagers mms = new MessageManagers();
        MessageManagerFactory factory = new MessageManagerFactory();
        MessageManager mm_a = factory.create("Alyssa", "csc207_TA");
        MessageManager mm_b = factory.create("Alyssa", "cat");
        mms.addMM(mm_a);
        mms.addMM(mm_b);
        Assertions.assertEquals(2, mms.getMMs().size());
        Assertions.assertTrue(mms.getMMs().contains(mm_a));
        Assertions.assertTrue(mms.getMMs().contains(mm_b));
    }

    @Test
    void getUserChatted_return_not_empty_Test(){
        MessageManagers mms_2 = new MessageManagers();
        MessageManagerFactory factory = new MessageManagerFactory();
        MessageManager mm_2 = factory.create("Alyssa", "Jenny");
        mms_2.addMM(mm_2);
        Assertions.assertTrue(mms_2.getUserChatted("Alyssa").contains("Jenny"));

    }

    @Test
    void getUserChatted_return_empty_Test(){
        MessageManagers mms_2 = new MessageManagers();
        mms_2.getUserChatted("Alyssa");
        Assertions.assertEquals(0, mms_2.getUserChatted("Alyssa").size());

    }


    @Test
    void find_user_return_Test(){
        MessageManagers mms_1 = new MessageManagers();
        MessageManagerFactory factory = new MessageManagerFactory();
        MessageManager mm_a = factory.create("user_01", "gradle_321c");
        mms_1.addMM(mm_a);
        assertSame(mms_1.find("user_01", "gradle_321c"), mm_a);
    }
    @Test
    void find_user_null_Test(){
        MessageManagers mms_2 = new MessageManagers();
        assertSame(mms_2.find("user_01", "gradle_321c"), null);
    }


}


