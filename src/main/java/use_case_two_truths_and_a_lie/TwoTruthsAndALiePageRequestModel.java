package use_case_two_truths_and_a_lie;
import entity.User;

/**
 *  Request Model for Two Truths And A Lie Page
 *  Bundles necessary input data and pass them into TwoTruthsAndALiePageManager
 *  @author  Eric Xue
 */
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
