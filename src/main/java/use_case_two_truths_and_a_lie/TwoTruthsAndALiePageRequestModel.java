package use_case_two_truths_and_a_lie;
import gui.TwoTruthsAndALiePagePanelInterface;

/**
 *  Request Model for Two Truths And A Lie Page
 *  Bundles necessary input data and pass them into TwoTruthsAndALiePageManager
 *  @author  Eric Xue
 */
public class TwoTruthsAndALiePageRequestModel {
    private String otherUser;

    private TwoTruthsAndALiePagePanelInterface panel;

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
    }
}
