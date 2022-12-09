package entity_test;

import entity.Block;
import entity.BlockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlockFactoryTest {

    private Block block;

    @BeforeEach
    public void initBlock(){
        block = new Block();
    }

    @Test
    public void testBlockFactory(){
        block = new Block();
        block.setBlockName("jack");
        block.setCurrName("rose");

        BlockFactory<Block> blockFactory = new BlockFactory<>();
        blockFactory.add(block);

        Assertions.assertEquals(blockFactory.size(), 1);

    }
}
