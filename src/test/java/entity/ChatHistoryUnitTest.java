package entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ChatHistoryUnitTest {
    @Test
    public void given2users_getUser1_thenIsTrue() {
        ChatHistory chatHistory= new ChatHistory("alyssa_my_li","jennifer_xxx");
        assertSame("alyssa_my_li", chatHistory.getUser1());
        assertSame("jennifer_xxx", chatHistory.getUser2());
    }
} 
