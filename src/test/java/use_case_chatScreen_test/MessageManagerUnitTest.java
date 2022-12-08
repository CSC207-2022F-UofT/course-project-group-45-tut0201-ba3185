package use_case_chatScreen_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case_message.MessageManager;
import use_case_message.MessageManagerFactory;
/**
 * Unit tests for the MessageManager class, which tests the get_user1 and get_user2, save_chat_history_test methods for most cases.
 *in save_chat_history test, the method getChatHistory isn't explicitly tested since save_chat_history_test has already used it
 * and it would be redundant if we use a similar approach to test it. getcontent method is also used here!
 */

public class MessageManagerUnitTest {
    MessageManagerFactory factory;
    MessageManager mm;
    @BeforeEach
    void init(){
        this.factory = new MessageManagerFactory();
        this.mm = factory.create("Alyssa","Wario_badr");
    }
    @Test
    void get_user1_test(){
        Assertions.assertSame( "Alyssa",mm.getUser1());
    }

    @Test
    void get_user2_test(){
        Assertions.assertSame("Wario_badr",mm.getUser2());
    }
    @Test
    void save_chat_history_test(){
        mm.SaveChatHistory("2022-12-06 23:20:11", "Alyssa","Hello, how are you");
        Assertions.assertSame("Hello, how are you", mm.getChatHistory().getContent().get("2022-12-06 23:20:11 Alyssa"));
    }

}
