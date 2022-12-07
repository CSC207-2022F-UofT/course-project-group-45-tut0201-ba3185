package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;

import java.io.IOException;
import java.util.List;

public interface TwoTruthsAndALiePageInputBoundary {
    public void createGame(TwoTruthsAndALiePageRequestModel requestModel) throws IOException;
    public TwoTruthsAndALiePageResponseModel loadUserGames() throws IOException;

}
