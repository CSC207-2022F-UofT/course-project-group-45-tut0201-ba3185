package use_case_two_truths_and_a_lie;

import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;

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

    public TwoTruthsAndALiePageManager(TwoTruthsAndALiePageOutputBoundary presenter) {
        this.presenter = presenter;
        this.games = new ArrayList<>();
    }

    public void createGame(TwoTruthsAndALiePageRequestModel requestModel) {
        TwoTruthsAndALiePlayer player1 = new TwoTruthsAndALiePlayer(requestModel.getCurrentUser());
        TwoTruthsAndALiePlayer player2 = new TwoTruthsAndALiePlayer(requestModel.getOtherUser());
        TwoTruthsAndALieGame game = new TwoTruthsAndALieGame(player1, player2);
        this.games.add(game);
    }

    /**
     * Loads all the games that the current user is a part of
     * Makes the presenter to show all current games
     */
    public void loadUserGames(TwoTruthsAndALiePageRequestModel requestModel) {
        List<TwoTruthsAndALieGame> userGames = new ArrayList<>();
        for (TwoTruthsAndALieGame game : this.games) {
            TwoTruthsAndALiePlayer[] players = game.getPlayers();
            if (players[0].getUser() == requestModel.getCurrentUser() || players[1].getUser() == requestModel.getCurrentUser()) {
                userGames.add(game);
            }
        }
        presenter.showGames(userGames);
    }

    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }
}

