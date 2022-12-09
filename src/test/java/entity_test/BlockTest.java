package entity_test;

import entity.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockTest {

    private Block block;

    @BeforeEach
    public void initBlock(){
        block = new Block();
    }

    @Test
    public void testBlock(){
        block = new Block();
        block.setBlockName("jack");
        block.setCurrName("rose");
        String name = block.getBlockName();
        String currName = block.getCurrName();
        Assertions.assertEquals(name, "jack");
        Assertions.assertEquals(currName, "rose");
    }
}
