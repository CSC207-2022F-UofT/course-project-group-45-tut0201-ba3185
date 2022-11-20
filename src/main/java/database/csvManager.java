package database;

import entity.User;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class csvManager {

    public HashMap<String, UserRequestModel> readUser(String path) throws IOException {
        /**
         * This method reads the user csv file to get all registered User
         *
         * @param path, the path of the csv file
         * @return a map of users
         * @throws IOException when the reader fails to read.
         */
        String row;
        File csv = new File(path);
        HashMap<String, UserRequestModel> userMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();
        while(row != null) {
            String[] col = row.split(",");
            String username = String.valueOf(col[1]);
            String name = String.valueOf(col[2]);
            String password = String.valueOf(col[3]);

            UserRequestModel currentUser = new UserRequestModel();
            currentUser.setInfo(username, name, password);
            userMap.put(username, currentUser);
            row = reader.readLine();
        }
        reader.close();
        return userMap;
    }

    public void writeUser(Map<String, UserResponseModel> userMap, String path) {
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
