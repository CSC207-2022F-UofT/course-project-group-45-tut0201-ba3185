package gui.game;
import gui.MainFrame;
import presenter.TwoTruthsAndALieGamePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TwoTruthsAndALieGamePanel extends JPanel implements TwoTruthsAndALieGamePanelInterface {

    private final String filler = "                                   ";
    TwoTruthsAndALieGamePresenter presenter;

    public TwoTruthsAndALieGamePanel(String otherUser) throws IOException {
        this.presenter = new TwoTruthsAndALieGamePresenter(this, otherUser);
        this.setPreferredSize(new Dimension(MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT / 3));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setBackground(Color.cyan);
        presenter.update();
    }

    public void showInputFields(String otherUser) {
        this.add(new JLabel("Game with " + otherUser));
        TextField truth1 = new TextField("Truth");
        this.add(truth1);
        TextField truth2 = new TextField("Truth");
        this.add(truth2);
        TextField lie = new TextField("Lie");
        this.add(lie);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            List<String> statements = new ArrayList<>();
            statements.add(truth1.getText());
            statements.add(truth2.getText());
            statements.add(lie.getText());
            try {
                presenter.saveStatements(statements);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(submitButton);
        this.revalidate();
    }

    public void showWaiting(String otherUser) {
        this.removeAll();
        JLabel title = new JLabel(filler + "Game with " + otherUser + filler);
        title.setMinimumSize(new Dimension(MainFrame.PAGE_WIDTH, 0));
        this.add(title);
        this.add(new JLabel("Waiting for Opponent to Submit Statements"));
        this.revalidate();
    }

    public void showChoices(String otherUser, List<String> statements) {
        this.removeAll();
        this.add(new JLabel(filler + "Game with " + otherUser + filler));
        Collections.shuffle(statements);
        JButton statement1 = new JButton(statements.get(0));
        statement1.addActionListener(e -> {
            try {
                presenter.submitChoice(statement1.getText(), otherUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(statement1);

        JButton statement2 = new JButton(statements.get(1));
        statement2.addActionListener(e -> {
            try {
                presenter.submitChoice(statement2.getText(), otherUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(statement2);

        JButton statement3 = new JButton(statements.get(2));
        statement3.addActionListener(e -> {
            try {
                presenter.submitChoice(statement3.getText(), otherUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(statement3);
        this.revalidate();
    }

    public void showWin() {
        this.removeAll();
        this.add(new Label(filler + "You Win!" + filler));
        this.revalidate();
    }

    public void showLose() {
        this.removeAll();
        this.add(new Label(filler + "You Lose!" + filler));
        this.revalidate();
    }
}
