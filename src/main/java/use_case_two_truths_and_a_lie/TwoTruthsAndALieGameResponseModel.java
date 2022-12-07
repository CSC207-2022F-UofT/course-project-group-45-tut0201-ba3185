package use_case_two_truths_and_a_lie;

public class TwoTruthsAndALieGameResponseModel {
    private boolean isCorrect;
    private String truth1;

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

    private String truth2;
    private String lie;

    public boolean isCorrect() {
        return isCorrect;
    }


    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
