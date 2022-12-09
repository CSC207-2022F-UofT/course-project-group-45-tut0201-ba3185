package use_case_blocklist;
import database.csvManager;
import entity.Block;
import entity.BlockFactory;
import entity.User;
import use_case_signin_signup.UserRequestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * BlockListManager is responsible for removing user
 * from current user's block list,
 * adding user to current user's block list,
 * or checking whether user is in current user's block list.
 */

public class BlockListManager implements BlockListInputBoundary {

    private final String path = "src/main/java/database/blockList.csv";
    private final UserRequestModel current;

    public BlockListManager() {
        csvManager manager = new csvManager();
        this.current = manager.readCurrentUser();
    }

    /**
     * adding user to current user's block list,
     */
    @Override
    public void addBlockList(User user) {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(
                "currName", "blockName"));
        String header = String.join(",", headers);
        BlockFactory<Block> arrayList = BlockGateWay.readCsvByBufferedReader();
        Block block1 = new Block();
        block1.setCurrName(current.getName());
        block1.setBlockName(user.getName());
        arrayList.add(block1);

        StringBuilder stringBuffer =new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Block block = arrayList.get(i);
            stringBuffer.append(block.getCurrName()).append(",").append(block.getBlockName());
            if (i < size -1) {
                stringBuffer.append("\n");
            }
        }
        writeStringToCsv(header, stringBuffer.toString(), path, false);
    }

    /**
     * removing user from current user's block list,
     */
    @Override
    public void removeBlockList(User user) {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(
                "currName", "blockName"));
        String header = String.join(",", headers);
        BlockFactory<Block> arrayList = BlockGateWay.readCsvByBufferedReader();
        StringBuilder stringBuffer =new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Block block = arrayList.get(i);
            if (block.getCurrName().equals(current.getName()) && block.getBlockName().equals(user.getName())) {
                arrayList.remove(i);
                break;
            }else {
                stringBuffer.append(block.getCurrName()).append(",").append(block.getBlockName());
                if (i < size -1) {
                    stringBuffer.append("\n");
                }
            }
        }
        writeStringToCsv(header, stringBuffer.toString(), path, false);
    }

    /**
     * checking whether user is in current user's block list.
     */
    @Override
    public int checkBlockList(User user) {
        BlockFactory<Block> arrayList = BlockGateWay.readCsvByBufferedReader();
        if (arrayList.size() == 0){
            return 0;
        }
        for (Block block: arrayList) {
            if (block.getCurrName().equals(current.getName()) && block.getBlockName().equals(user.getName())) {
                return 1;
            }
            if (block.getCurrName().equals(user.getName()) && block.getBlockName().equals(current.getName())) {
                return 2;
            }
        }
        return 0;
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


