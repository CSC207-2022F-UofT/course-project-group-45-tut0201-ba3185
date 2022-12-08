package database;

import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.TwoTruthsAndALieStatements;
import entity.User;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;

import java.io.*;
import java.util.*;

public class csvManager implements csvInterface {

    /**
     * csvManager is the database interactor that reads and writes to the various data files
     *
     * @param userPath is the path to the user data file
     * @param currentUserPath is the path to the currentUser data file
     */
    private final String USER_PATH = "src/main/java/database/user.csv";
    private final String CURRENT_USER_PATH = "src/main/java/database/currentUser.csv";
    private final String GAME_PATH = "src/main/java/database/game.csv";

    public Map<String, UserRequestModel> readUser() throws IOException {
        /**
         * This method reads the user csv file to get all registered User
         *
         * @param path, the path of the csv file
         * @return a map of usernames and UserRequestModels
         * @throws IOException when the reader fails to read.
         */
        String row;
        File csv = new File(USER_PATH);
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

            List<String> interestRanked = List.of(interestRank.split("/"));

            String areaOfInterest = String.valueOf(col[12]);
            ArrayList<Double> currentLocation = new ArrayList<>();
            currentLocation.add(Double.parseDouble(String.valueOf(col[13])));
            currentLocation.add(Double.parseDouble(String.valueOf(col[14])));

            UserRequestModel currentUser = new UserRequestModel();
            currentUser.setInfo(username, name, password, age, income, gender,relationshipType,maritalStatus,pet,
                    currentLocation, sexualOrientation, interestRanked, areaOfInterest);
            userMap.put(username, currentUser);
            row = reader.readLine();
        }
        reader.close();
        return userMap;
    }

    public UserRequestModel readCurrentUser() {
        /**
         * reads the current user from the currentUser data file
         * @return a userResponse model of the data from currentUser data file
         * @throws IOException when the reader fails to read
         */
        try {
            File csv = new File(CURRENT_USER_PATH);
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
                List<String> interestRanked = List.of(interestRank.split("/"));

                System.out.println(interestRanked);

                String areaOfInterest = String.valueOf(col[11]);
                ArrayList<Double> location = new ArrayList<>();
                location.add(Double.parseDouble(col[12]));
                location.add(Double.parseDouble(col[13]));

                UserRequestModel responseModel = new UserRequestModel();
                responseModel.setInfo(username, name, password,
                        age, income, gender,relationshipType, maritalStatus,pet,location,sexualOrientation,
                        interestRanked, areaOfInterest);
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
                                 Map<String, Object> userSetting, List<String> interestRank, String areaOfInterest) {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("username",
                "name", "password", "gender", "age", "income", "pet", "maritalStatus", "relationshipType",
                "sexualOrientation","interestRank","areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CURRENT_USER_PATH));
            writer.write(String.join(",", Headers));
            writer.newLine();

            String interestRanks = interestRank.toString();
            interestRanks = interestRanks.replace(", ", "/");
            interestRanks = interestRanks.substring(1, interestRanks.length()-1);

            String write = (username+","+name+","+password+","+
                    userSetting.get("gender")+","+userSetting.get("age")+","+userSetting.get("income")+"," +
                    userSetting.get("pet")+","+userSetting.get("maritalStatus")+","+
                    userSetting.get("relationshipType")+","+userSetting.get("sexualOrientation")+","+interestRanks+
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
                "name", "password", "gender", "age", "income", "pet", "maritalStatus", "relationshipType",
                "sexualOrientation","interestRank","areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_PATH));
            writer.write(String.join(",", Headers));
            writer.newLine();

            for(int i = userMap.values().size()-1 ; i >=  0; i--) {
                UserResponseModel currentUser = (UserResponseModel) userMap.values().toArray()[i];
                List<Double> location = currentUser.getLocation();
                Map<String, Object> userSettings = currentUser.getUserSetting();

                String interestRank = currentUser.getInterestRank().toString();
                interestRank = interestRank.replace(", ", "/");
                interestRank = interestRank.substring(1,interestRank.length()-1);

                System.out.println(interestRank);

                String write = (i+","+currentUser.getUsername()+","+currentUser.getName()+","+currentUser.getPassword()
                        +","+ userSettings.get("gender")+","+userSettings.get("age")+","+userSettings.get("income")+
                        "," + userSettings.get("pet")+","+userSettings.get("maritalStatus")+","+
                        userSettings.get("relationshipType")+","+userSettings.get("sexualOrientation")+","+
                        interestRank+","+currentUser.getAreaOfInterest()+","+
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

    /**
     * @return the full list of all ongoing Two Truths And A Lie games
     * @throws IOException
     */
    public List<TwoTruthsAndALieGame> readGames() throws IOException {
        /**
         * This method reads the game csv file to get all games
         *
         * @return a list of games
         * @throws IOException when the reader fails to read.
         */

        Map<String, UserRequestModel> userMap = this.readUser();

        String row;
        File csv = new File(GAME_PATH);
        List<TwoTruthsAndALieGame> gameList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();
        while(row != null) {
            String[] col = row.split(",");
            String player1_username = String.valueOf(col[0]);
            UserRequestModel requestModel = userMap.get(player1_username);
            User user1 = new User(requestModel.getUsername(), requestModel.getName(), requestModel.getPassword(),
                    requestModel.getLocation(), requestModel.getUserSetting(), requestModel.getInterestRank(),
                    requestModel.getAreaOfInterest());
            TwoTruthsAndALiePlayer player1 = new TwoTruthsAndALiePlayer(user1);
            player1.setStatements(new TwoTruthsAndALieStatements(String.valueOf(col[1]),   // truth 1
                                                                 String.valueOf(col[2]),   // truth 2
                                                                 String.valueOf(col[3]))); // lie

            String player2_username = String.valueOf(col[4]);
            requestModel = userMap.get(player2_username);

            User user2 = new User(requestModel.getUsername(), requestModel.getName(), requestModel.getPassword(),
                    requestModel.getLocation(), requestModel.getUserSetting(), requestModel.getInterestRank(),
                    requestModel.getAreaOfInterest());
            TwoTruthsAndALiePlayer player2 = new TwoTruthsAndALiePlayer(user2);
            player2.setStatements(new TwoTruthsAndALieStatements(String.valueOf(col[5]),   // truth 1
                    String.valueOf(col[6]),   // truth 2
                    String.valueOf(col[7]))); // lie

            TwoTruthsAndALieGame game = new TwoTruthsAndALieGame(player1, player2);
            gameList.add(game);
            row = reader.readLine();
        }
        reader.close();
        return gameList;
    }

    /**
     * Writes a single Two Truths And A Lie game entity to the end of the csv
     */
    public void writeGame(TwoTruthsAndALieGame game) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(GAME_PATH, true));

            TwoTruthsAndALiePlayer player1 = game.getPlayers()[0];
            TwoTruthsAndALiePlayer player2 = game.getPlayers()[1];

            String write =  player1.getUser().getUsername()+","+
                            player1.getStatements().getTruth1()+","+
                            player1.getStatements().getTruth2()+","+
                            player1.getStatements().getLie()+","+
                            player2.getUser().getUsername()+","+
                            player2.getStatements().getTruth1()+","+
                            player2.getStatements().getTruth2()+","+
                            player2.getStatements().getLie();
            writer.write(write);
            writer.newLine();
            writer.close();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Writes the statements that the current user entered for a game to the corresponding location in the csv file
     */
    public void writeGameStatements(TwoTruthsAndALieStatements statements, String user1, String user2) throws IOException {
        List<TwoTruthsAndALieGame> gameList = this.readGames();
        for (TwoTruthsAndALieGame game: gameList) {

            // If this game is the target game, it is updated
            if (game.getPlayers()[0].getUser().getUsername().equals(user1) && game.getPlayers()[1].getUser().getUsername().equals(user2) ||
                    game.getPlayers()[0].getUser().getUsername().equals(user2) && game.getPlayers()[1].getUser().getUsername().equals(user1)) {

                TwoTruthsAndALiePlayer player1 = game.getPlayers()[0];
                TwoTruthsAndALiePlayer player2 = game.getPlayers()[1];

                // If player1 is current user, add statements to player1
                if (player1.getUser().equals(this.readCurrentUser())) {
                    player1.setStatements(statements);
                }
                else{
                    player2.setStatements(statements);
                }
            }
        }

        writeGames(gameList);
    }

    /**
     * Deletes a Two Truths And A Lie game from the csv file
     * @throws IOException
     */
    public void deleteGame(String otherUser) throws IOException {
        String currentUser = this.readCurrentUser().getUsername();
        List<TwoTruthsAndALieGame> gameList = this.readGames();
        TwoTruthsAndALieGame targetGame = null;
        for (TwoTruthsAndALieGame game: gameList) {

            // If this game is the target game, it is deleted
            if (game.getPlayers()[0].getUser().getUsername().equals(currentUser) && game.getPlayers()[1].getUser().getUsername().equals(otherUser) ||
                    game.getPlayers()[0].getUser().getUsername().equals(otherUser) && game.getPlayers()[1].getUser().getUsername().equals(currentUser)) {
                targetGame = game;
                break;
            }
        }
        gameList.remove(targetGame);
        writeGames(gameList);
    }

    /**
     * Writes a list of Two Truths And A Lie game entity to the end of the csv
     * Extracted from writeGameStatements and deleteGames
     */
    private void writeGames(List<TwoTruthsAndALieGame> gameList) {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(
                "user1_username", "user1_truth1", "user1_truth2", "user1_lie",
                "user2_username", "user2_truth1", "user2_truth2", "user2_lie"));
        try {
            // Write headers
            BufferedWriter writer = new BufferedWriter(new FileWriter(GAME_PATH));
            writer.write(String.join(",", headers));
            writer.newLine();
            writer.close();

            // Write all games back
            for (TwoTruthsAndALieGame game : gameList) {
                this.writeGame(game);
            }
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void logoutUser() {
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password", "gender", "age", "income", "pet", "maritalStatus", "relationshipType",
                "sexualOrientation","interestRank", "areaOfInterest","locationX", "locationY"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CURRENT_USER_PATH));
            writer.write(String.join(",", Headers));
        }
        catch(IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
