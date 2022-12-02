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
    // private List<User> userList;
    private List<UserForTest> userList;
    private Map<String, String> answerList;



    public SearchListHelper(SearchAnswerRequestModel model){
        this.model = model;
        System.out.println(model.getIncomeLow() + "helper");
        GenderFinder tempGenderFinder = new GenderFinder();
        this.userList = tempGenderFinder.genderSuitFinder;

    }

    public void generateList(){
        SearchAnswerConverter converter = new SearchAnswerConverter(model);
        answerList = converter.getAnswer();

        SearchScoreCalculator scoreCalculator = new SearchScoreCalculator(answerList);
        //for(User user: userList){
        Map<UserForTest, Integer> userListWithScore = new HashMap<>();

        for(UserForTest otherUser:userList){
            //scoreCalculator.calculateScore(user);
            //UserListWithScore.put(user, scoreCalculator.getScore());
            scoreCalculator.calculateScore(otherUser);
            userListWithScore.put(otherUser,scoreCalculator.getScore() );

        }
        ScoreHelper scoreHelper = new ScoreHelper(userListWithScore);
        this. recommendedList = scoreHelper.getList(); // get the sorted list using the helper

    }

    public List<String> getList(){
        generateList();
        return recommendedList;
    }


}
