package use_case.two_truths_and_a_lie;
import java.io.IOException;
import java.util.*;

import database.csvManager;
import entity.*;
import use_case.signin_signup.UserRequestModel;

/**
 * The `TwoTruthsAndALieGameManager` class is a concrete implementation of the `TwoTruthsAndALieGameInputBoundary`
 * interface. It is the use case responsible for managing the game logic of a game of Two Truths and a Lie, including
 * determining the game state and calculating if a user's chosen statement is correct.
 *
 * @author Eric Xue
 * @see TwoTruthsAndALieGameInputBoundary
 */
public class TwoTruthsAndALieGameManager implements TwoTruthsAndALieGameInputBoundary {

    private TwoTruthsAndALieGame game;

    public TwoTruthsAndALieGameManager(String otherUserUsername) throws IOException {
        UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
        User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                currentUserRequestModel.getAreaOfInterest());
        Map<String, UserRequestModel> userMap = new csvManager().readUser();
        UserRequestModel requestModel = userMap.get(otherUserUsername);
        User otherUser = new User(requestModel.getUsername(), requestModel.getName(), requestModel.getPassword(),
                requestModel.getLocation(), requestModel.getUserSetting(), requestModel.getInterestRank(),
                requestModel.getAreaOfInterest());
        List<TwoTruthsAndALieGame> gameList = new csvManager().readGames();
        for (TwoTruthsAndALieGame game : gameList) {
            if (game.getPlayers()[0].getUser().compareTo(currentUser) == 0 && game.getPlayers()[1].getUser().compareTo(otherUser) == 0
                || game.getPlayers()[1].getUser().compareTo(currentUser) == 0 && game.getPlayers()[0].getUser().compareTo(otherUser) == 0) {
                this.game = game;
                break;
            }
        }
    }

    /**
     * @return the string representation of the game state
     */
    public String getGameState() {
        if (findCurrentPlayer().getStatements().isEmpty()) {
            return "entering";
        }
        else if (this.game.getPlayers()[0].getStatements().isEmpty() || this.game.getPlayers()[1].getStatements().isEmpty()) {
            return "waiting";
        }
        else {
            return "selecting";
        }
    }

    /**
     * Saves the statements that a user has inputted into the game entity and the csv file
     */
    public void saveStatements(TwoTruthsAndALieGameRequestModel requestModel) throws IOException {
        TwoTruthsAndALieStatements statements = new TwoTruthsAndALieStatements(
                                                    requestModel.getTruth1(),
                                                    requestModel.getTruth2(),
                                                    requestModel.getLie());
        TwoTruthsAndALiePlayer currentPlayer = this.findCurrentPlayer();


        currentPlayer.setStatements(statements);

        new csvManager().writeGameStatements(statements,
                                             this.findCurrentPlayer().getUser().getUsername(),
                                             this.findOtherPlayer().getUser().getUsername());
    }

    public TwoTruthsAndALieGameResponseModel isCorrect(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer otherPlayer = this.findOtherPlayer();
        TwoTruthsAndALieGameResponseModel responseModel = new TwoTruthsAndALieGameResponseModel();
        responseModel.setCorrect(Objects.equals(otherPlayer.getStatements().getLie(), requestModel.getChosenStatement()));
        return responseModel;
    }

    /**
     * A helper method for generating and returning a player entity representing the current user in the game
     * @return TwoTruthsAndALiePlayer
     */
    public TwoTruthsAndALiePlayer findCurrentPlayer() {
        TwoTruthsAndALiePlayer[] players = this.game.getPlayers();
        UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
        User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                currentUserRequestModel.getAreaOfInterest());
        if (players[0].getUser().compareTo(currentUser) == 0) {
            return players[0];
        }
        else {
            return players[1];
        }
    }

    /**
     * A helper method for generating and returning a player entity representing the other user in the game
     * @return TwoTruthsAndALiePlayer
     */
    public TwoTruthsAndALiePlayer findOtherPlayer() {
        TwoTruthsAndALiePlayer[] players = this.game.getPlayers();
        UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
        User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                currentUserRequestModel.getAreaOfInterest());
        if (players[0].getUser().compareTo(currentUser) == 0) {
            return players[1];
        }
        else {
            return players[0];
        }
    }

    /**
     * Returns the statements that the other player has entered
     */
    public List<String> getOtherPlayerStatementStrings() {
        TwoTruthsAndALieStatements statements = this.findOtherPlayer().getStatements();
        List<String> statementStrings = new ArrayList<>();
        statementStrings.add(statements.getTruth1());
        statementStrings.add(statements.getTruth2());
        statementStrings.add(statements.getLie());
        return statementStrings;
    }
}
