package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface TwoTruthsAndALieGameInputBoundary {

    public void saveStatements(TwoTruthsAndALieGameRequestModel requestModel) throws IOException;

    public TwoTruthsAndALieGameResponseModel loadStatements(TwoTruthsAndALieGameRequestModel requestModel);

    public TwoTruthsAndALieGameResponseModel isCorrect(TwoTruthsAndALieGameRequestModel requestModel);

    public List<String> getOtherPlayerStatementStrings();
}
