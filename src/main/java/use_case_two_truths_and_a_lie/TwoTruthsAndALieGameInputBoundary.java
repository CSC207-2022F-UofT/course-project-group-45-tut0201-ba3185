package use_case_two_truths_and_a_lie;
import entity.TwoTruthsAndALieGame;
import entity.TwoTruthsAndALiePlayer;
import entity.User;
import java.util.List;

public interface TwoTruthsAndALieGameInputBoundary {

    public void saveStatements(TwoTruthsAndALieGameRequestModel requestModel);

    public void loadStatements(TwoTruthsAndALieGameRequestModel requestModel);

    public void isCorrect(TwoTruthsAndALieGameRequestModel requestModel);
}
