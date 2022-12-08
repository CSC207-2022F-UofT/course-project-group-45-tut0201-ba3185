package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import gui.TwoTruthsAndALiePagePanelInterface;
import java.util.List;

/**
 *  Response Model for Two Truths And A Lie Page
 *  Bundles necessary output data and pass them into TwoTruthsAndALiePagePresenter
 *  @author  Eric Xue
 */

public class TwoTruthsAndALiePageResponseModel {
    List<TwoTruthsAndALieGame> games;

    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }

    public void setGames(List<TwoTruthsAndALieGame> games) {
        this.games = games;
    }
}
