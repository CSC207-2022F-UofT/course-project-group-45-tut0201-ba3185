package use_case_two_truths_and_a_lie;
import entity.User;
import gui.TwoTruthsAndALiePagePanelInterface;

import javax.swing.*;

/**
 *  Request Model for Two Truths And A Lie Page
 *  Bundles necessary input data and pass them into TwoTruthsAndALiePageManager
 *  @author  Eric Xue
 */
public class TwoTruthsAndALiePageRequestModel {
    private User currentUser;
    private User otherUser;

    private TwoTruthsAndALiePagePanelInterface panel;

    public TwoTruthsAndALiePagePanelInterface getPanel() {
        return panel;
    }

    public void setPanel(TwoTruthsAndALiePagePanelInterface panel) {
        this.panel = panel;
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

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }
}
