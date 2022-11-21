package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class MessageUnitTest {
    @Test
    void getMessageTest() {
        Message msg = new Message("Alyssa thinks Jennifer is really smart and lovely");
        assertSame(msg.getMessage(), "Alyssa thinks Jennifer is really smart and lovely");
    }
}
