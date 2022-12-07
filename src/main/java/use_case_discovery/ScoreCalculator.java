package use_case_discovery;
/**
 * This is the interface to use Facade Design pattern.
 * Since ScoreCalculator originally has two actor: search and preference;
 * Therefore, we use Facade Design pattern by
 * implementing the interface on SearchScoreCalculator and PreferenceScoreCalculator
 */
public interface ScoreCalculator {
    int getScore();
}
