package use_case_two_truths_and_a_lie;
import entity.User;

public class TwoTruthsAndALiePageRequestModel {
    private User currentUser;
    private User otherUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }
}
