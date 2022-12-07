package use_case_two_truths_and_a_lie;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import presenter.TwoTruthsAndALiePagePresenter;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *  Use Case for Two Truths And A Lie Game Page
 *  Responsible for managing the page of Two Truths and A Lie games, without managing the details of each game
 *  @author  Eric Xue
 */
public class TwoTruthsAndALiePageManager implements TwoTruthsAndALiePageInputBoundary{

    private List<TwoTruthsAndALieGame> games;

    public TwoTruthsAndALiePageManager() {
        this.games = new ArrayList<>();
    }

    public void createGame(TwoTruthsAndALiePageRequestModel requestModel) throws IOException {

        User currentUser = new csvManager().readCurrentUser();
        HashMap<String, UserRequestModel> userMap = new csvManager().readUser();
        ArrayList<Object> otherUserInfo = userMap.get(requestModel.getOtherUser()).getInfo();
        User otherUser = new User((String) otherUserInfo.get(0),
                                  (String) otherUserInfo.get(1),
                                  (String) otherUserInfo.get(2),
                                  (ArrayList<Double>) otherUserInfo.get(3),
                                  (HashMap<String, Object>) otherUserInfo.get(4));

        // If the other user is already a part of a game that the current user is in, do nothing and return
        for (TwoTruthsAndALieGame game : this.games) {
            if (otherUser.compareTo(game.getPlayers()[0].getUser()) == 0 || otherUser.compareTo(game.getPlayers()[1].getUser()) == 0 ) {
                return;
            }
        }

        TwoTruthsAndALiePlayer player1 = new TwoTruthsAndALiePlayer(currentUser);
        TwoTruthsAndALiePlayer player2 = new TwoTruthsAndALiePlayer(otherUser);
        TwoTruthsAndALieGame game = new TwoTruthsAndALieGame(player1, player2);

        this.games.add(game);
        new csvManager().writeGame(game);
    }

    /**
     * Loads all the games that the current user is a part of
     * Makes the presenter to show all current games
     */
    public TwoTruthsAndALiePageResponseModel loadUserGames() throws IOException {
        List<TwoTruthsAndALieGame> userGames = new ArrayList<>();

        this.games = new csvManager().readGames();

        for (TwoTruthsAndALieGame game : this.games) {
            TwoTruthsAndALiePlayer[] players = game.getPlayers();

            User currentUser = new csvManager().readCurrentUser();
            if (players[0].getUser().compareTo(currentUser) == 0 || players[1].getUser().compareTo(currentUser) == 0) {
                userGames.add(game);
            }
        }
        TwoTruthsAndALiePageResponseModel responseModel = new TwoTruthsAndALiePageResponseModel();
        responseModel.setGames(userGames);
        return responseModel;
    }

    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }
}

