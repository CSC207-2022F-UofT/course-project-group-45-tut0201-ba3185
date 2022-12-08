package use_case_blocklist;


import entity.Block;
import entity.BlockFactory;

import java.io.*;

public class BlockGateWay {
    /**
     BlockGateWay is used to read blockList.csv file
     */
    public static BlockFactory readCsvByBufferedReader() {
        String filePath = "src/main/java/database/blockList.csv";
        File csv = new File(filePath);
        csv.setReadable(true);
        csv.setWritable(true);
        InputStreamReader isr = null;
        BufferedReader br = null;

        BlockFactory records = new BlockFactory();
        if (!csv.exists()){
            return records;
        }

        try {
            isr = new InputStreamReader(new FileInputStream(csv), "UTF-8");
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
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
