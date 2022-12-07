package use_case_chatScreen_test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case_message.MessageManager;
import use_case_message.MessageManagerFactory;
import use_case_message.MessageManagers;

import static org.junit.jupiter.api.Assertions.assertSame;

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


