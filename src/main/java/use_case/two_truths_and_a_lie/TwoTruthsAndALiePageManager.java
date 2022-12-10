package use_case.two_truths_and_a_lie;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import use_case.signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The `TwoTruthsAndALiePageManager` class is a concrete implementation of the `TwoTruthsAndALiePageInputBoundary`
 * interface. It is the use case responsible for managing the overall game section of the app, including
 * creating games and loading all the games for a user.
 *
 * @author Eric Xue
 * @see TwoTruthsAndALieGameInputBoundary
 */
public class TwoTruthsAndALiePageManager implements TwoTruthsAndALiePageInputBoundary{

    private List<TwoTruthsAndALieGame> games;

    public TwoTruthsAndALiePageManager() {
        this.games = new ArrayList<>();
    }

    /**
     * Creates a single Two Truths And A Lie game, adding it to the list of games and the csv file
     * @throws IOException throws IOException when necessary
     */
    public void createGame(TwoTruthsAndALiePageRequestModel requestModel) throws IOException {

        UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
        User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                currentUserRequestModel.getAreaOfInterest());

        Map<String, UserRequestModel> userMap = new csvManager().readUser();
        UserRequestModel otherUserRequestModel = userMap.get(requestModel.getOtherUser());
        User otherUser = new User(otherUserRequestModel.getUsername(), otherUserRequestModel.getName(), otherUserRequestModel.getPassword(),
                otherUserRequestModel.getLocation(), otherUserRequestModel.getUserSetting(), otherUserRequestModel.getInterestRank(),
                otherUserRequestModel.getAreaOfInterest());

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
     * Loads all the games that the current user is a part of and return them to the presenter
     */
    public TwoTruthsAndALiePageResponseModel loadUserGames() throws IOException {
        List<TwoTruthsAndALieGame> userGames = new ArrayList<>();

        this.games = new csvManager().readGames();

        for (TwoTruthsAndALieGame game : this.games) {
            TwoTruthsAndALiePlayer[] players = game.getPlayers();

            UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
            User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                    currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                    currentUserRequestModel.getAreaOfInterest());
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

