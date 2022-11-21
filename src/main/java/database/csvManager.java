package database;

import entity.User;
import entity.UserFactory;
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

    public User readCurrentUser(String path) {
        try {
            File csv = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            reader.readLine();
            String row = reader.readLine();
            if(row != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[1]);
                String name = String.valueOf(col[2]);
                String password = String.valueOf(col[3]);
                String gender = String.valueOf(col[4]);
                int age = Integer.parseInt(col[5]);
                int income = Integer.parseInt(col[6]);
                String pet = String.valueOf(col[7]);
                String maritalStatus = String.valueOf(col[8]);
                String relationshipType = String.valueOf(col[9]);
                String location = col[10];
                String[] tmp = location.split(",");
                ArrayList<Double> currentLocation = new ArrayList<>();
                currentLocation.add(Double.valueOf(tmp[0]));
                currentLocation.add(Double.valueOf(tmp[1]));

                HashMap<String, Object> userInfo = new HashMap<>();
                userInfo.put("gender", gender);
                userInfo.put("age", age);
                userInfo.put("income", income);
                userInfo.put("pet", pet);
                userInfo.put("maritalStatus", maritalStatus);
                userInfo.put("relationshipType", relationshipType);

                User user = new User(username, name, password, currentLocation, userInfo);
                return user;
            }
            return null;
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeCurrentUser(UserResponseModel responseModel, String path) {
        ArrayList<String> Headers = new ArrayList<>(Arrays.asList("username", "name", "password","gender", "age",
                "income", "pet", "maritalStatus", "relationshipType", "location"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(String.join(",", Headers));
            writer.newLine();

            ArrayList<Object> userInfo = responseModel.getAllInfo();
            String write = (userInfo.get(0)+","+userInfo.get(1)+","+userInfo.get(2)+","+userInfo.get(3)+","+
                    userInfo.get(4)+","+userInfo.get(5)+","+userInfo.get(6)+","+userInfo.get(7)+","+
                    userInfo.get(8)+","+userInfo.get(9));
            writer.write(write);
            writer.close();
        }
        catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeUser(Map<String, UserResponseModel> userMap, String path) {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(String.join(",", Headers));
            writer.newLine();

            for(int i = userMap.values().size()-1 ; i >=  0; i--) {
                UserResponseModel currentUser = (UserResponseModel) userMap.values().toArray()[i];
                ArrayList<Object> userInfo = currentUser.getInfo();
                String write = (i+","+userInfo.get(0)+","+userInfo.get(1)+","+userInfo.get(2));
                writer.write(write);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
