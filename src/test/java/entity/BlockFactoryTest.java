package entity;

import org.junit.Test;

public class BlockFactoryTest {

    @Test
    public void testBlockFactory(){
        Block block = new Block();
        block.setBlockName("jack");
        block.setCurrName("rose");

        BlockFactory<Block> blockFactory = new BlockFactory<>();
        blockFactory.add(block);

    }
}
