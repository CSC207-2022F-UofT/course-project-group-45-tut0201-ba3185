package database;

import entity.User;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class csvInteractor {

    public Map<String, User> readUser(String path) throws IOException {
        /**
         * This method reads the user csv file to get all registered User
         *
         * @param path, the path of the csv file
         * @return a map of users
         * @throws IOException when the reader fails to read.
         */
        String row;
        File csv = new File(path);
        Map<String, User> userMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();
        while(row != null) {
            String[] col = row.split(",");
            String username = String.valueOf(col[1]);
            String name = String.valueOf(col[2]);
            String password = String.valueOf(col[3]);

            User current = new User(username, name,password);
            userMap.put(username, current);
            row = reader.readLine();
        }
        reader.close();
        return userMap;
    }

    public void writeUser(Map<String, User> userMap, String path) {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(String.join(",", Headers));
            writer.newLine();


        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
