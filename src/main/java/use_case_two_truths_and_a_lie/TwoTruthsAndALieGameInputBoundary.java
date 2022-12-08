package use_case_two_truths_and_a_lie;

import java.io.IOException;
import java.util.List;

public interface TwoTruthsAndALieGameInputBoundary {

    void saveStatements(TwoTruthsAndALieGameRequestModel requestModel) throws IOException;

    TwoTruthsAndALieGameResponseModel isCorrect(TwoTruthsAndALieGameRequestModel requestModel);

    List<String> getOtherPlayerStatementStrings();
}
