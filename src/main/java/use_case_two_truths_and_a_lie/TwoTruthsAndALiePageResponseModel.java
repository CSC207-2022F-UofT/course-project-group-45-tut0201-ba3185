package use_case_two_truths_and_a_lie;


import entity.TwoTruthsAndALieGame;
import gui.TwoTruthsAndALiePagePanelInterface;

import javax.swing.*;
import java.util.List;

/**
 *  Response Model for Two Truths And A Lie Presenter
 *  Bundles necessary output data and pass them into TwoTruthsAndALiePresenter
 *  @author  Eric Xue
 */

public class TwoTruthsAndALiePageResponseModel {
    public TwoTruthsAndALiePagePanelInterface getPanel() {
        return panel;
    }

    public void setPanel(TwoTruthsAndALiePagePanelInterface panel) {
        this.panel = panel;
    }

    List<TwoTruthsAndALieGame> games;
    TwoTruthsAndALiePagePanelInterface panel;



    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }

    public void setGames(List<TwoTruthsAndALieGame> games) {
        this.games = games;
    }
}
