package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import java.util.List;

public interface TwoTruthsAndALiePageInputBoundary {
    public void createGame(TwoTruthsAndALiePageRequestModel requestModel);
    public void loadUserGames(TwoTruthsAndALiePageRequestModel requestModel);
}
