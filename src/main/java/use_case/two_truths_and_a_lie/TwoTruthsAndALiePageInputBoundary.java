package use_case.two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;

import java.io.IOException;
import java.util.List;

public interface TwoTruthsAndALiePageInputBoundary {
    void createGame(TwoTruthsAndALiePageRequestModel requestModel) throws IOException;
    TwoTruthsAndALiePageResponseModel loadUserGames() throws IOException;
    List<TwoTruthsAndALieGame> getGames();
}
