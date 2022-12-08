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

    private static final String userPath = "src/main/java/database/user.csv";
    private static final String currentUserPath = "src/main/java/database/currentUser.csv";

    public static HashMap<String, UserRequestModel> readUser() throws IOException {
        /*
         * This method reads the user csv file to get all registered User
         *
         * @param path, the path of the csv file
         * @return a map of users
         * @throws IOException when the reader fails to read.
         */
        String row;
        File csv = new File(userPath);
        HashMap<String, UserRequestModel> userMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();
        while(row != null) {
            String[] col = row.split(",");
            String username = String.valueOf(col[1]);
            String name = String.valueOf(col[2]);
            String password = String.valueOf(col[3]);
            String gender = String.valueOf(col[4]);
            int age = Integer.parseInt(String.valueOf(col[5]));
            int income = Integer.parseInt(String.valueOf(col[6]));
            String pet = String.valueOf(col[7]);
            String maritalStatus = String.valueOf(col[8]);
            String relationshipType = String.valueOf(col[9]);
            ArrayList<Double> currentLocation = new ArrayList<>();
            currentLocation.add(Double.parseDouble(String.valueOf(col[10])));
            currentLocation.add(Double.parseDouble(String.valueOf(col[11])));

            UserRequestModel currentUser = new UserRequestModel();
            currentUser.setInfo(username, name, password, age, income, gender,relationshipType,maritalStatus,pet,
                    currentLocation);
            userMap.put(username, currentUser);
            row = reader.readLine();
        }
        reader.close();
        return userMap;
    }

    public static User readCurrentUser() {
        try {
            File csv = new File(currentUserPath);
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            reader.readLine();
            String row = reader.readLine();
            if(row != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[0]);
                String name = String.valueOf(col[1]);
                String password = String.valueOf(col[2]);
                String gender = String.valueOf(col[3]);
                int age = Integer.parseInt(col[4]);
                int income = Integer.parseInt(col[5]);
                String pet = String.valueOf(col[6]);
                String maritalStatus = String.valueOf(col[7]);
                String relationshipType = String.valueOf(col[8]);
                ArrayList<Double> location = new ArrayList<>();
                location.add(Double.parseDouble(col[9]));
                location.add(Double.parseDouble(col[10]));

                HashMap<String, Object> userInfo = new HashMap<>();
                userInfo.put("gender", gender);
                userInfo.put("age", age);
                userInfo.put("income", income);
                userInfo.put("pet", pet);
                userInfo.put("maritalStatus", maritalStatus);
                userInfo.put("relationshipType", relationshipType);

                User user = new User(username, name, password, location, userInfo);
                return user;
            }
            return null;
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeCurrentUser(String username, String name, String password, ArrayList<Double> location,
            HashMap<String, Object> userSetting) {
        ArrayList<String> Headers = new ArrayList<>(Arrays.asList("username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType", "locationX",
                "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentUserPath));
            writer.write(String.join(",", Headers));
            writer.newLine();

            String write = (username+","+name+","+password+","+
                        userSetting.get("gender")+","+userSetting.get("age")+","+userSetting.get("income")+"," +
                        userSetting.get("pet")+","+userSetting.get("maritalStatus")+","+
                        userSetting.get("relationshipType")+","+location.get(0)+","+ location.get(1));

            writer.write(write);
            writer.close();
        }
        catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writeUser(Map<String, UserResponseModel> userMap) {
        ArrayList<String> Headers = new ArrayList<>(Arrays.asList("id", "username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType", "locationX",
                "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userPath));
            writer.write(String.join(",", Headers));
            writer.newLine();

            for(int i = userMap.values().size()-1 ; i >=  0; i--) {
                UserResponseModel currentUser = (UserResponseModel) userMap.values().toArray()[i];
                ArrayList<Object> userInfo = currentUser.getInfo();
                ArrayList<Double> location = (ArrayList<Double>) userInfo.get(3);
                HashMap<String, Object> userSettings = (HashMap<String, Object>) userInfo.get(4);
                String write = (i+","+userInfo.get(0)+","+userInfo.get(1)+","+userInfo.get(2)+","+
                        userSettings.get("gender")+","+userSettings.get("age")+","+userSettings.get("income")+"," +
                        userSettings.get("pet")+","+userSettings.get("maritalStatus")+","+
                        userSettings.get("relationshipType")+","+location.get(0)+","+ location.get(1));
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
