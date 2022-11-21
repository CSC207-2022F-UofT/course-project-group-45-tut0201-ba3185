package gui;
import controller.TwoTruthsAndALiePageController;
import entity.TwoTruthsAndALieGame;
import presenter.TwoTruthsAndALiePagePresenter;

import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALiePagePanel extends JPanel implements TwoTruthsAndALiePagePanelInterface {

    TwoTruthsAndALiePageController controller;
    TwoTruthsAndALiePagePresenter presenter;

    public TwoTruthsAndALiePagePanel() {
        this.controller = new TwoTruthsAndALiePageController();
        this.presenter = new TwoTruthsAndALiePagePresenter();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel createGamePanel = new JPanel();
        createGamePanel.setBackground(Color.pink);
        JButton createGameButton = new JButton();
        createGameButton.setText("Create game");
        createGameButton.addActionListener(e -> {
            controller.createGame(this);
        });
        createGamePanel.add(createGameButton);
        this.add(createGamePanel);

        controller.showUserGames(this);
    }

    public void update(TwoTruthsAndALiePagePanelViewModel viewModel) {
        for (TwoTruthsAndALieGame game: viewModel.games) {
            TwoTruthsAndALieGamePanel gamePanel = new TwoTruthsAndALieGamePanel();
            this.add(gamePanel);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
            this.revalidate();

        }
    }
}
