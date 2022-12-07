package presenter;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.User;
import gui.TwoTruthsAndALiePagePanelInterface;
import use_case_signin_signup.UserRequestModel;
import use_case_two_truths_and_a_lie.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoTruthsAndALiePagePresenter implements TwoTruthsAndALiePageOutputBoundary {

    private final TwoTruthsAndALiePagePanelInterface view;
    private final TwoTruthsAndALiePageInputBoundary manager;

    public TwoTruthsAndALiePagePresenter(TwoTruthsAndALiePagePanelInterface view) {
        this.view = view;
        this.manager = new TwoTruthsAndALiePageManager();
    }

    public void createGame(String otherUser) throws IOException {
        TwoTruthsAndALiePageRequestModel requestModel = new TwoTruthsAndALiePageRequestModel();
        requestModel.setOtherUser(otherUser);
        manager.createGame(requestModel);
        this.showUserGames();
    }

    public void showUserGames() throws IOException {
        TwoTruthsAndALiePageResponseModel responseModel = manager.loadUserGames();
        view.update();
        for(TwoTruthsAndALieGame game: responseModel.getGames()) {

            // If current user is player1, player2 is other user
            if (new csvManager().readCurrentUser().compareTo(game.getPlayers()[0].getUser()) == 0) {
                view.addGame(game.getPlayers()[1].getUser().getUsername());
            }
            else {
                view.addGame(game.getPlayers()[0].getUser().getUsername());
            }
        }
    }

    public void showUserButtons(JPanel createGamePanel) throws IOException {
        HashMap<String, UserRequestModel> userMap = new csvManager().readUser();
        List<User> users = new ArrayList<>();
        for (String username: userMap.keySet()) {
            ArrayList<Object> userInfo = userMap.get(username).getInfo();
            User user = new User((String) userInfo.get(0),
                                 (String) userInfo.get(1),
                                 (String) userInfo.get(2),
                                 (ArrayList<Double>) userInfo.get(3),
                                 (HashMap<String, Object>) userInfo.get(4));
            users.add(user);
        }

        for (User user: users) {
            if (user.compareTo(new csvManager().readCurrentUser()) != 0) {
                view.addUserButton(user.getUsername(), createGamePanel);
            }
        }
    }
}