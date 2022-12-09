package entity_test;

import entity.ChatHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the entity ChatHistory class which tests the get user method, however, get_content is not tested since
 * this method is used and tested in later save_chat_history_test in MessageMangersUnitTest.
 */
public class ChatHistoryUnitTest {
    @Test
    public void given2users_getUser_thenIsTrue() {
        ChatHistory chatHistory= new ChatHistory("alyssa_my_li","jennifer_xxx");
        assertSame("alyssa_my_li", chatHistory.getUser1());
        assertSame("jennifer_xxx", chatHistory.getUser2());
    }

    @Test
    public void given2users_getUser_thenIsFalse() {
        ChatHistory chatHistory= new ChatHistory("mooga","paula");
        assertNotSame("paula", chatHistory.getUser1());
        assertNotSame("mooga", chatHistory.getUser2());
    }
}