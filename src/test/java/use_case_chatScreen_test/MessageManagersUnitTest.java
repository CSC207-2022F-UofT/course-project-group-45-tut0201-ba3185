package use_case_chatScreen_test;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import use_case_message.MessageManager;
import use_case_message.MessageManagerFactory;
import use_case_message.MessageManagers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class MessageManagersUnitTest {
    MessageManagerFactory mmf;
    MessageManagers mms;
    MessageManager a;
    MessageManager b;

    @Before
    public void setup(){
        mms = new MessageManagers();
        mmf = new MessageManagerFactory();
        a = mmf.create("alyssa", "jennifer");
        b = mmf.create("alyssa","Elon_Musk");
    }
    @Test
    void addMessageManagerTest() {
        mms.addMM(a);
        mms.addMM(b);
        List<MessageManager> messageManagers = mms.getMMs();
        assertSame(messageManagers.size(), 2);
        assertSame(messageManagers.contains(a), true);
        assertSame(messageManagers.contains(b), true);
    }
    @Test
    void getMMsTest(){
        ArrayList<MessageManager> mmslist = new ArrayList<MessageManager>();
        mmslist.add(a);
        mmslist.add(b);
        assertSame(mms.getMMs(), mmslist);
    }
    @Test
    void find_returnMMTest(){

    }
    @Test
    void find_returnNullTest(){}
    @After
    public void tearDown(){}
}
