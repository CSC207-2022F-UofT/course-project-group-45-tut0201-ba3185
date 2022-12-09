package use_case_blocklist;


import entity.Block;
import entity.BlockFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BlockGateWay {
    /**
     BlockGateWay is used to read blockList.csv file
     */
    public static BlockFactory<Block> readCsvByBufferedReader() {
        String filePath = "src/main/java/database/blockList.csv";
        File csv = new File(filePath);
        boolean isRead =csv.setReadable(true);
        boolean isWrite = csv.setWritable(true);
        System.out.println(isRead);
        System.out.println(isWrite);
        InputStreamReader isr;
        BufferedReader br = null;

        BlockFactory<Block> records = new BlockFactory<>();
        if (!csv.exists()){
            return records;
        }

        try {
            isr = new InputStreamReader(new FileInputStream(csv), StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while (null != br && null != (line = br.readLine())) {
                System.out.println(line);
                Block block = new Block();
                block.setCurrName(line.split(",")[0]);
                block.setBlockName(line.split(",")[1]);
                records.add(block);
            }
            System.out.println("read row from csv file:" + records.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        records.remove(0);
        return records;
    }
}
