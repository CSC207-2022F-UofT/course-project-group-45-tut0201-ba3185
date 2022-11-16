package entity;

/**
 *  A Two Truths And A Lie Statements Entity
 *  Belongs to a player entity; keeps track of that player's statements
 *  @author  Eric Xue
 */
public class TwoTruthsAndALieStatements {
    String truth1;
    String truth2;
    String lie;

    public TwoTruthsAndALieStatements(String truth1, String truth2, String lie) {
        this.truth1 = truth1;
        this.truth2 = truth2;
        this.lie = lie;
    }

    public String getTruth1() {
        return truth1;
    }

    public String getTruth2() {
        return truth2;
    }

    public String getLie() {
        return lie;
    }
}
