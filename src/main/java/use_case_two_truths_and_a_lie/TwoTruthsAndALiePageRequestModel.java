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
    private String currentUser;
    private String otherUser;

    private TwoTruthsAndALiePagePanelInterface panel;

    public TwoTruthsAndALiePagePanelInterface getPanel() {
        return panel;
    }

    public void setPanel(TwoTruthsAndALiePagePanelInterface panel) {
        this.panel = panel;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
    }
}
