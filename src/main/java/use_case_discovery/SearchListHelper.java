package use_case_discovery;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This function help generate the recommended list
 */
public class SearchListHelper {
    private SearchAnswerRequestModel model;
    private List<String> recommendedList;
    private List<User> userList;
    private Map<String, String> answerList;


    public SearchListHelper(SearchAnswerRequestModel model){
        this.model = model;
        GenderFinder tempGenderFinder = new GenderFinder();
        userList = tempGenderFinder.genderSuitFinder;

        SearchAnswerConverter converter = new SearchAnswerConverter(model);
        answerList = converter.getAnswer();
    }

    public void generateList(){
        Map<User, Integer> UserListWithScore = new HashMap<>();
        SearchScoreCalculator scoreCalculator = new SearchScoreCalculator(answerList);
        for(User user: userList){
            scoreCalculator.calculateScore(user);
            UserListWithScore.put(user, scoreCalculator.getScore());
        }
        ScoreHelper scoreHelper = new ScoreHelper(UserListWithScore);
        this. recommendedList = scoreHelper.getList(); // get the sorted list using the helper

    }

    public List<String> getList(){
        generateList();
        return recommendedList;
    }


}
