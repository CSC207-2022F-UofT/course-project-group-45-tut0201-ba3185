package use_case_two_truths_and_a_lie;
import java.io.IOException;
import java.util.*;

import database.csvManager;
import entity.*;
import presenter.TwoTruthsAndALieGamePresenter;
import use_case_signin_signup.UserRequestModel;

/**
 *  Use Case for Two Truths And A Lie Game
 *  Interacts with a single Two Truths and A Lie Game entity at a time
 *  @author  Eric Xue
 */
public class TwoTruthsAndALieGameManager implements TwoTruthsAndALieGameInputBoundary {

    private TwoTruthsAndALieGame game;

    public TwoTruthsAndALieGameManager(String otherUserUsername) throws IOException {
        User currentUser = new csvManager().readCurrentUser();
        HashMap<String, UserRequestModel> userMap = new csvManager().readUser();
        ArrayList<Object> otherUserInfo = userMap.get(otherUserUsername).getInfo();
        User otherUser = new User((String) otherUserInfo.get(0),
                (String) otherUserInfo.get(1),
                (String) otherUserInfo.get(2),
                (ArrayList<Double>) otherUserInfo.get(3),
                (HashMap<String, Object>) otherUserInfo.get(4));
        List<TwoTruthsAndALieGame> gameList = new csvManager().readGames();
        for (TwoTruthsAndALieGame game : gameList) {
            if (game.getPlayers()[0].getUser().compareTo(currentUser) == 0 && game.getPlayers()[1].getUser().compareTo(otherUser) == 0
                || game.getPlayers()[1].getUser().compareTo(currentUser) == 0 && game.getPlayers()[0].getUser().compareTo(otherUser) == 0) {
                this.game = game;
                break;
            }
        }
    }

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
     * Saves the statements that a user has inputted
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

    /**
     * Loads the statements that the other user has inputted
     * If the other player has no statements, make the presenter display loading status
     * Otherwise, display the statements to the current player
     */
    public TwoTruthsAndALieGameResponseModel loadStatements(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer player = this.findCurrentPlayer();
        TwoTruthsAndALieStatements statements = player.getStatements();
        TwoTruthsAndALieGameResponseModel responseModel = new TwoTruthsAndALieGameResponseModel();
        responseModel.setTruth1(statements.getTruth1());
        responseModel.setTruth1(statements.getTruth2());
        responseModel.setTruth1(statements.getLie());
        return responseModel;
    }

    public TwoTruthsAndALieGameResponseModel isCorrect(TwoTruthsAndALieGameRequestModel requestModel) {
        TwoTruthsAndALiePlayer otherPlayer = this.findOtherPlayer();
        TwoTruthsAndALieGameResponseModel responseModel = new TwoTruthsAndALieGameResponseModel();
        responseModel.setCorrect(Objects.equals(otherPlayer.getStatements().getLie(), requestModel.getChosenStatement()));
        return responseModel;
    }

    /**
     * A helper method for finding the player entity given the current user and a game
     * @return TwoTruthsAndALiePlayer
     */
    public TwoTruthsAndALiePlayer findCurrentPlayer() {
        TwoTruthsAndALiePlayer[] players = this.game.getPlayers();
        if (players[0].getUser().compareTo(new csvManager().readCurrentUser()) == 0) {
            return players[0];
        }
        else {
            return players[1];
        }
    }

    public TwoTruthsAndALiePlayer findOtherPlayer() {
        TwoTruthsAndALiePlayer[] players = this.game.getPlayers();
        if (players[0].getUser().compareTo(new csvManager().readCurrentUser()) == 0) {
            return players[1];
        }
        else {
            return players[0];
        }
    }

    public List<String> getOtherPlayerStatementStrings() {
        TwoTruthsAndALieStatements statements = this.findOtherPlayer().getStatements();
        List<String> statementStrings = new ArrayList<>();
        statementStrings.add(statements.getTruth1());
        statementStrings.add(statements.getTruth2());
        statementStrings.add(statements.getLie());
        return statementStrings;
    }
}
