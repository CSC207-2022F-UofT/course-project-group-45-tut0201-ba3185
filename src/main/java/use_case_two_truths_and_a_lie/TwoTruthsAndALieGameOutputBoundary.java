package use_case_two_truths_and_a_lie;

import database.csvManager;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.TwoTruthsAndALieStatements;
import entity.User;
import use_case_signin_signup.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public interface TwoTruthsAndALieGameOutputBoundary {
    public void update();
}
