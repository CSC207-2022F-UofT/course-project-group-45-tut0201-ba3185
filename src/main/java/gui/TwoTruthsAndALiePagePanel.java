package gui;
import presenter.TwoTruthsAndALiePagePresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TwoTruthsAndALiePagePanel extends JPanel implements TwoTruthsAndALiePagePanelInterface {

    TwoTruthsAndALiePagePresenter presenter;

    public TwoTruthsAndALiePagePanel() throws IOException {
        this.presenter = new TwoTruthsAndALiePagePresenter(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        presenter.showUserGames();
    }

    public void update() throws IOException {
        this.removeAll();
        JPanel createGamePanel = new JPanel();
        createGamePanel.setBackground(Color.pink);
        createGamePanel.setLayout(new GridLayout(3, 2));
        createGamePanel.setMinimumSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 8));
        createGamePanel.setAlignmentX(CENTER_ALIGNMENT);
        presenter.showUserButtons(createGamePanel);
        this.add(createGamePanel);
    }

    public void addUserButton(String username, JPanel createGamePanel) {
        JButton createGameButton = new JButton();
        createGameButton.setText(username);
        createGameButton.addActionListener(e -> {
            try {
                presenter.createGame(createGameButton.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        createGamePanel.add(createGameButton);
    }

    public void addGame(String otherUser) throws IOException {
        TwoTruthsAndALieGamePanel gamePanel = new TwoTruthsAndALieGamePanel(otherUser);
        this.add(gamePanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.revalidate();
    }
}
