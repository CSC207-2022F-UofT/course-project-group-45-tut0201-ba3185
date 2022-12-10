package use_case.two_truths_and_a_lie;

import javax.swing.*;
import java.io.IOException;

public interface TwoTruthsAndALiePageOutputBoundary {
    void createGame(String otherUser) throws IOException;

    void showUserGames() throws IOException;

    void showUserButtons(JPanel createGamePanel) throws IOException;
}
