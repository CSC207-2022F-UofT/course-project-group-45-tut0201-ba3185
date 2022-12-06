package gui;
import controller.TwoTruthsAndALieGameController;
import presenter.TwoTruthsAndALieGamePresenter;

import javax.swing.*;
import java.awt.*;

public class TwoTruthsAndALieGamePanel extends JPanel {

    TwoTruthsAndALieGameController controller;
    TwoTruthsAndALieGamePresenter presenter;

    public TwoTruthsAndALieGamePanel() {
        this.controller = new TwoTruthsAndALieGameController();
        this.presenter = new TwoTruthsAndALieGamePresenter();

        this.setSize(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3);
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3));

        this.setBackground(Color.cyan);

        JButton gameButton = new JButton();
        gameButton.setText("Play game");

        controller.showGameDetails();
    }

    public void update(TwoTruthsAndALieGamePanelViewModel viewModel) {
        JLabel label = new JLabel("Game");
        this.add(label);
    }
}
