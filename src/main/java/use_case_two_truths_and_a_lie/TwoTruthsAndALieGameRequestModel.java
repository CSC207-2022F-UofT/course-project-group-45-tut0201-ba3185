package use_case_two_truths_and_a_lie;
import entity.User;
import entity.TwoTruthsAndALieGame;

public class TwoTruthsAndALieGameRequestModel {
    private TwoTruthsAndALieGame game;
    private User currentUser;
    private User otherUser;
    private String truth1;
    private String truth2;
    private String lie;

    private String chosenStatement;

    public TwoTruthsAndALieGame getGame() {
        return game;
    }

    public void setGame(TwoTruthsAndALieGame game) {
        this.game = game;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getOtherUser() {
        return otherUser;
    }

    public String getChosenStatement() {
        return chosenStatement;
    }

    public void setChosenStatement(String chosenStatement) {
        this.chosenStatement = chosenStatement;
    }

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }

    public String getTruth1() {
        return truth1;
    }

    public void setTruth1(String truth1) {
        this.truth1 = truth1;
    }

    public String getTruth2() {
        return truth2;
    }

    public void setTruth2(String truth2) {
        this.truth2 = truth2;
    }

    public String getLie() {
        return lie;
    }

    public void setLie(String lie) {
        this.lie = lie;
    }
}
