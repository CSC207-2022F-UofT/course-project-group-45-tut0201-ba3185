package use_case_two_truths_and_a_lie;

/**
 *  Response Model for Two Truths And A Lie Game
 *  Bundles necessary input data and pass them into TwoTruthsAndALieGamePresenter
 *  @author  Eric Xue
 */
public class TwoTruthsAndALieGameResponseModel {
    private boolean isCorrect;
    public String getLie() {
        return lie;
    }

    public void setLie(String lie) {
        this.lie = lie;
    }
    private String lie;

    public boolean isCorrect() {
        return isCorrect;
    }


    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
