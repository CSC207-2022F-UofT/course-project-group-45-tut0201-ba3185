package use_case_two_truths_and_a_lie;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import presenter.TwoTruthsAndALiePagePresenter;

import java.util.ArrayList;
import java.util.List;


/**
 *  Use Case for Two Truths And A Lie Game Page
 *  Responsible for managing the page of Two Truths and A Lie games, without managing the details of each game
 *  @author  Eric Xue
 */
public class TwoTruthsAndALiePageManager implements TwoTruthsAndALiePageInputBoundary{

    private List<TwoTruthsAndALieGame> games;
    private TwoTruthsAndALiePageOutputBoundary presenter;

    public TwoTruthsAndALiePageManager() {
        this.presenter = new TwoTruthsAndALiePagePresenter();
        this.games = new ArrayList<>();
    }

    public void createGame(TwoTruthsAndALiePageRequestModel requestModel) {
        User currentUser = new csvManager().readCurrentUser("src/main/java/database/currentUser.csv");
        // TODO: set player2 to a different user
        TwoTruthsAndALiePlayer player1 = new TwoTruthsAndALiePlayer(currentUser);
        TwoTruthsAndALiePlayer player2 = new TwoTruthsAndALiePlayer(currentUser);
        TwoTruthsAndALieGame game = new TwoTruthsAndALieGame(player1, player2);
        this.games.add(game);
        this.loadUserGames(requestModel);
    }

    /**
     * Loads all the games that the current user is a part of
     * Makes the presenter to show all current games
     */
    public void loadUserGames(TwoTruthsAndALiePageRequestModel requestModel) {
        List<TwoTruthsAndALieGame> userGames = new ArrayList<>();
        System.out.println(this.games.size());
        for (TwoTruthsAndALieGame game : this.games) {
            TwoTruthsAndALiePlayer[] players = game.getPlayers();

            User currentUser = new csvManager().readCurrentUser("src/main/java/database/currentUser.csv");
            if (players[0].getUser().compareTo(currentUser) == 0 || players[1].getUser().compareTo(currentUser) == 0) {
                userGames.add(game);
            }
        }
        TwoTruthsAndALiePageResponseModel responseModel = new TwoTruthsAndALiePageResponseModel();
        responseModel.setPanel(requestModel.getPanel());
        responseModel.setGames(userGames);
        presenter.showGames(responseModel);
    }

    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }
}

