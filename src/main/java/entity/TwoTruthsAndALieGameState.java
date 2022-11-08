package entity;

public class TwoTruthsAndALieGameState {
    public final String ENTERING = "enteringStatements";
    public final String WAITING_OPP = "waitingForOpponent";
    public final String WAITING_SEL = "waitingForSelection";
    public final String DISPLAYING_RES = "displayingResult";

    public final String FINISHED = "finished";
    private String currentState;

    public TwoTruthsAndALieGameState() {
        currentState = ENTERING;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
        // TODO: add assert input
    }
}
