package presenter;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.User;
import gui.game.TwoTruthsAndALiePagePanelInterface;
import use_case.signin_signup.UserRequestModel;
import use_case.two_truths_and_a_lie.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The `TwoTruthsAndALiePagePresenter` class is a concrete implementation of the `TwoTruthsAndALiePageOutputBoundary`
 * interface. It is a presenter responsible for presenting a page of Two Truths and a Lie games to the user.
 *
 * @author Eric Xue
 * @see TwoTruthsAndALiePageOutputBoundary
 */
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

            UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
            User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                    currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                    currentUserRequestModel.getAreaOfInterest());

            // If current user is player1, player2 is other user
            if (currentUser.compareTo(game.getPlayers()[0].getUser()) == 0) {
                view.addGame(game.getPlayers()[1].getUser().getUsername());
            }
            else {
                view.addGame(game.getPlayers()[0].getUser().getUsername());
            }
        }
    }

    public void showUserButtons(JPanel createGamePanel) throws IOException {
        Map<String, UserRequestModel> userMap = new csvManager().readUser();


        List<User> users = new ArrayList<>();
        for (String username: userMap.keySet()) {

            UserRequestModel requestModel = userMap.get(username);
            User user = new User(requestModel.getUsername(), requestModel.getName(), requestModel.getPassword(),
                    requestModel.getLocation(), requestModel.getUserSetting(), requestModel.getInterestRank(),
                    requestModel.getAreaOfInterest());
            users.add(user);
        }

        Collections.shuffle(users);
        for (int i = 0; i < 6; i++) {
            UserRequestModel currentUserRequestModel = new csvManager().readCurrentUser();
            User currentUser = new User(currentUserRequestModel.getUsername(), currentUserRequestModel.getName(), currentUserRequestModel.getPassword(),
                    currentUserRequestModel.getLocation(), currentUserRequestModel.getUserSetting(), currentUserRequestModel.getInterestRank(),
                    currentUserRequestModel.getAreaOfInterest());

            if (users.get(i).compareTo(currentUser) != 0) {
                view.addUserButton(users.get(i).getUsername(), createGamePanel);
            }
        }
    }
}