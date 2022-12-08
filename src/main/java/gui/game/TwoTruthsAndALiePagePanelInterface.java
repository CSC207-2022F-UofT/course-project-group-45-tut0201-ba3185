package gui.game;

import javax.swing.*;
import java.io.IOException;

public interface TwoTruthsAndALiePagePanelInterface {
    void update() throws IOException;

    void addGame(String username) throws IOException;

    void addUserButton(String username, JPanel createGamePanel);
}
