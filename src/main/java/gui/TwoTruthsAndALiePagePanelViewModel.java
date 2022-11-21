package gui;

import entity.TwoTruthsAndALieGame;

import java.awt.*;
import java.util.List;

public class TwoTruthsAndALiePagePanelViewModel {
    List<TwoTruthsAndALieGame> games;

    public List<TwoTruthsAndALieGame> getGames() {
        return games;
    }

    public void setGames(List<TwoTruthsAndALieGame> games) {
        this.games = games;
    }
}
