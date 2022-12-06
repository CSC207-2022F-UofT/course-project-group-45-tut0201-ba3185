package database;

import entity.User;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;

import java.io.*;
import java.util.*;

public class csvManager {

    /**
     * csvManager is the database interactor that reads and writes to the various data files
     *
     * @param userPath is the path to the user data file
     * @param currentUserPath is the path to the currentUser data file
     */

    private final String userPath = "src/main/java/database/user.csv";
    private final String currentUserPath = "src/main/java/database/currentUser.csv";

    public Map<String, UserRequestModel> readUser() throws IOException {
        /**
         * This method reads the user csv file to get all registered User
         *
         * @param path, the path of the csv file
         * @return a map of usernames and UserRequestModels
         * @throws IOException when the reader fails to read.
         */
        String row;
        File csv = new File(userPath);
        Map<String, UserRequestModel> userMap = new HashMap<>();

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
            String sexualOrientation = String.valueOf(col[10]);
            String interestRank = String.valueOf(col[11]);
            String areaOfInterest = String.valueOf(col[12]);
            ArrayList<Double> currentLocation = new ArrayList<>();
            currentLocation.add(Double.parseDouble(String.valueOf(col[13])));
            currentLocation.add(Double.parseDouble(String.valueOf(col[14])));

            UserRequestModel currentUser = new UserRequestModel();
            currentUser.setInfo(username, name, password, age, income, gender,relationshipType,maritalStatus,pet,
                    currentLocation, sexualOrientation, interestRank, areaOfInterest);
            userMap.put(username, currentUser);
            row = reader.readLine();
        }
        reader.close();
        return userMap;
    }

    public UserResponseModel readCurrentUser() {
        /**
         * reads the current user from the currentUser data file
         * @return a userResponse model of the data from currentUser data file
         * @throws IOException when the reader fails to read
         */
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
                String sexualOrientation = String.valueOf(col[9]);
                String interestRank = String.valueOf(col[10]);
                String areaOfInterest = String.valueOf(col[11]);
                ArrayList<Double> location = new ArrayList<>();
                location.add(Double.parseDouble(col[11]));
                location.add(Double.parseDouble(col[12]));

                UserResponseModel responseModel = new UserResponseModel();
                responseModel.setInfo(username, name, password,
                        age, income, gender,relationshipType, maritalStatus,pet,location,sexualOrientation,
                        interestRank, areaOfInterest);
                return responseModel;
            }
            return null;
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * write to the currentUser data file with the new user information
     * @param username: username of the user
     * @param name: name of the user
     * @param password: password of the user
     * @param location: location of the user
     * @param userSetting: user information
     *
     * @throws IOException if the reader fails to read
     */
    public void writeCurrentUser(String username, String name, String password, List<Double> location,
            Map<String, Object> userSetting, String interestRank, String areaOfInterest) {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType",
                "sexualOrientation","interestRank","areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentUserPath));
            writer.write(String.join(",", Headers));
            writer.newLine();

            String write = (username+","+name+","+password+","+
                        userSetting.get("gender")+","+userSetting.get("age")+","+userSetting.get("income")+"," +
                        userSetting.get("pet")+","+userSetting.get("maritalStatus")+","+
                        userSetting.get("relationshipType")+","+userSetting.get("sexualOrientation")+","+ interestRank+
                    ","+areaOfInterest+","+location.get(0)+","+ location.get(1));

            writer.write(write);
            writer.close();
        }
        catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * writes to the user data file, writes all the users in the database
     * @param userMap: map of username and UserResponse model
     */
    public void writeUser(Map<String, UserResponseModel> userMap) {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType",
                "sexualOrientation","interestRank","areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userPath));
            writer.write(String.join(",", Headers));
            writer.newLine();

            for(int i = userMap.values().size()-1 ; i >=  0; i--) {
                UserResponseModel currentUser = (UserResponseModel) userMap.values().toArray()[i];
                List<Double> location = currentUser.getLocation();
                Map<String, Object> userSettings = currentUser.getUserSetting();
                String write = (i+","+currentUser.getUsername()+","+currentUser.getName()+","+currentUser.getPassword()
                        +","+ userSettings.get("gender")+","+userSettings.get("age")+","+userSettings.get("income")+
                        "," + userSettings.get("pet")+","+userSettings.get("maritalStatus")+","+
                        userSettings.get("relationshipType")+","+userSettings.get("sexualOrientation")+","+
                        currentUser.getInterestRank()+","+currentUser.getAreaOfInterest()+","+
                        location.get(0)+","+ location.get(1));
                writer.write(write);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void logoutUser() {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType",
                "sexualOrientation","interestRank", "areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentUserPath));
            writer.write(String.join(",", Headers));
        }
        catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
