package database;

import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.TwoTruthsAndALieStatements;
import entity.User;
import presenter.TwoTruthsAndALiePagePresenter;
import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;

import java.io.*;
import java.util.*;

public class csvManager {

    private final String userPath = "src/main/java/database/user.csv";
    private final String currentUserPath = "src/main/java/database/currentUser.csv";

    private final String gamePath = "src/main/java/database/game.csv";

    public HashMap<String, UserRequestModel> readUser() throws IOException {
        /**
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

    public User readCurrentUser() {
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
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType","locationX",
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
        ArrayList<String> Headers = new ArrayList<String>(Arrays.asList("id", "username",
                "name", "password", "gender", "age", "income", "pet", "martialStatus", "relationshipType","locationX",
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

    public List<TwoTruthsAndALieGame> readGames() throws IOException {
        /**
         * This method reads the game csv file to get all games
         *
         * @return a list of games
         * @throws IOException when the reader fails to read.
         */

        HashMap<String, UserRequestModel> userMap = this.readUser();

        String row;
        File csv = new File(gamePath);
        List<TwoTruthsAndALieGame> gameList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        reader.readLine();
        row = reader.readLine();
        while(row != null) {
            String[] col = row.split(",");
            String player1_username = String.valueOf(col[0]);
            ArrayList<Object> user1Info = userMap.get(player1_username).getInfo();
            User user1 = new User((String) user1Info.get(0),
                    (String) user1Info.get(1),
                    (String) user1Info.get(2),
                    (ArrayList<Double>) user1Info.get(3),
                    (HashMap<String, Object>) user1Info.get(4));
            TwoTruthsAndALiePlayer player1 = new TwoTruthsAndALiePlayer(user1);
            player1.setStatements(new TwoTruthsAndALieStatements(String.valueOf(col[1]),   // truth 1
                                                                 String.valueOf(col[2]),   // truth 2
                                                                 String.valueOf(col[3]))); // lie

            String player2_username = String.valueOf(col[4]);
            ArrayList<Object> user2Info = userMap.get(player2_username).getInfo();
            User user2 = new User((String) user2Info.get(0),
                    (String) user2Info.get(1),
                    (String) user2Info.get(2),
                    (ArrayList<Double>) user2Info.get(3),
                    (HashMap<String, Object>) user2Info.get(4));
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

    public void writeGame(TwoTruthsAndALieGame game) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath, true));

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

    private void writeGames(List<TwoTruthsAndALieGame> gameList) {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(
                "user1_username", "user1_truth1", "user1_truth2", "user1_lie",
                "user2_username", "user2_truth1", "user2_truth2", "user2_lie"));
        try {
            // Write headers
            BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath));
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
}

