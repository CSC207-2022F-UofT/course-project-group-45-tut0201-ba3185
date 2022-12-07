package database;

import entity.User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class msgDataManager {

    private static final String DATABASE_PATH = "src/main/java/database/message.csv";

    public void addMessage(String sender, String reciever, String message) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_PATH));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dateTime = dtf.format(now);
            String line = (sender+","+reciever+","+message+","+dateTime);
            writer.append(line);
            writer.close();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);

        }
    }

    public Map<String,List<String>> getMessage(String user) throws IOException {
        String row;
        File csv = new File(DATABASE_PATH);
        Map<String, List<String>> messageMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();;

        while(row != null) {
            String[] col = row.split(",");

            if(col[0].equals(user)){
                List<String> messageTime = new ArrayList<>();
                messageTime.add(col[2]);
                messageTime.add(col[3]);
                messageMap.put(col[1], messageTime);
            }
        }
        return messageMap;
    }

}
