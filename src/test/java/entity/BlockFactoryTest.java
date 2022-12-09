package entity;

import entity.Block;
import entity.BlockFactory;
import org.junit.Test;

public class BlockFactoryTest {

    @Test
    public void testBlockFactory(){
        Block block = new Block();
        block.setBlockName("jack");
        block.setCurrName("rouse");

        BlockFactory<Block> blockFactory = new BlockFactory<>();
        blockFactory.add(block);

    }
}
