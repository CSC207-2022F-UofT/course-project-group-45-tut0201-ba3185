package use_case_two_truths_and_a_lie;

public interface TwoTruthsAndALieGameOutputBoundary {
    void showInputFields();
    void showWaitingForStatements();
    void showStatements(String[] statements);
    void showResult(Boolean isCorrect);
}
