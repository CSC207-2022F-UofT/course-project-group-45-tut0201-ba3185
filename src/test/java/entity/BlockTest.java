package entity;

import entity.Block;
import org.junit.Test;

public class BlockTest {

    @Test
    public void testBlock(){
        Block block = new Block();
        block.setBlockName("jack");
        block.setCurrName("rouse");
        block.getBlockName();
        block.getCurrName();
    }
}
