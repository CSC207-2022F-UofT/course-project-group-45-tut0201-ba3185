package gui;

import java.util.List;

public interface TwoTruthsAndALieGamePanelInterface {
    void showInputFields(String otherUser);

    void showWaiting(String otherUser);

    void showChoices(String otherUser, List<String> statements);

    void showWin();

    void showLose();
}
