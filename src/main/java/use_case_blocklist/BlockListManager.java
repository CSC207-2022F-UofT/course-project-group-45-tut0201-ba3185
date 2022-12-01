package use_case_blocklist;
import GateWay.BlockGateWay;
import database.csvManager;
import entity.Block;
import entity.BlockFactory;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class BlockListManager implements BlockListInputBoundary {

    private String path = "src/main/java/database/blockList.csv";
    private User current;

    public BlockListManager() {
        csvManager manager = new csvManager();
        this.current = manager.readCurrentUser("src/main/java/database/currentUser.csv");;
    }

    @Override
    public void addBlockList(User user) {
        ArrayList<String> headers = new ArrayList<String>(Arrays.asList(
                "currName", "blockName"));
        String header = String.join(",", headers);
        BlockFactory arrayList = BlockGateWay.readCsvByBufferedReader();
        Block block1 = new Block();
        block1.setCurrName(current.getName());
        block1.setBlockName(user.getName());
        arrayList.add(block1);

        StringBuffer stringBuffer =new StringBuffer();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Block block = (Block) arrayList.get(i);
            stringBuffer.append(block.getCurrName()+"," + block.getBlockName());
            if (i < size -1) {
                stringBuffer.append("\n");
            }
        }
        writeStringToCsv(header, stringBuffer.toString(), path, false);
    }

    @Override
    public void removeBlockList(User user) {
        ArrayList<String> headers = new ArrayList<String>(Arrays.asList(
                "currName", "blockName"));
        String header = String.join(",", headers);
        BlockFactory arrayList = BlockGateWay.readCsvByBufferedReader();
        StringBuffer stringBuffer =new StringBuffer();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Block block = (Block) arrayList.get(i);
            if (block.getCurrName().equals(current.getName()) && block.getBlockName().equals(user.getName())) {
                arrayList.remove(i);
            }else {
                stringBuffer.append(block.getCurrName()+"," + block.getBlockName());
                if (i < size -1) {
                    stringBuffer.append("\n");
                }
            }
        }
        writeStringToCsv(header, stringBuffer.toString(), path, false);
    }

    @Override
    public boolean checkBlockList(User user) {
        BlockFactory arrayList = BlockGateWay.readCsvByBufferedReader();
        if (arrayList.size() == 0){
            return false;
        }
        for (Object block: arrayList) {
            if (((Block)block).getCurrName().equals(current.getName()) && ((Block)block).getBlockName().equals(user.getName())) {
                return true;
            }
        }
        return false;
    }


    public void writeStringToCsv(String head, String dataStr, String csvFilePath, boolean append) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(csvFilePath, append);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            if (head != null) {
                bufferedWriter.write(head);
                bufferedWriter.newLine();
            }

            if (dataStr != null) {
                bufferedWriter.write(dataStr);
            }

            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


