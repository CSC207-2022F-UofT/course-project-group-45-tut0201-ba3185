package use_case.discovery.search;


import use_case.discovery.GenderInteractor;
import use_case.discovery.ScoreHelper;
import use_case.discovery.SearchScoreCalculator;
import use_case.discovery.search.SearchAnswerConverter;
import use_case.discovery.search.SearchAnswerRequestModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This function help generate the recommended list by getting user's answer
 * and generate the score then sort to find the first 15 matching user.
 */
public class SearchListHelper {
    private final SearchAnswerRequestModel model;
    private List<String> recommendedList;


    public SearchListHelper(SearchAnswerRequestModel model){
        this.model = model;

    }

    /**
     * The method generate the recommended list by calling the score
     * calculator and score helper.
     */
    public void generateList(){


        GenderInteractor genderInteractor = new GenderInteractor();
        List<String> userList = genderInteractor.getList();


        SearchAnswerConverter converter = new SearchAnswerConverter(model);
        Map<String, String> answerList = converter.getAnswer();
        Map<String, Integer> userListWithScore = new HashMap<>();
        SearchScoreCalculator scoreCalculator = new SearchScoreCalculator(answerList);


        for(String user: userList){ // need to change to User
            scoreCalculator.calculateScore(user);
            userListWithScore.put(user,scoreCalculator.getScore());

        }
        ScoreHelper scoreHelper = new ScoreHelper(userListWithScore);
        this. recommendedList = scoreHelper.getList(); // get the sorted list using the helper
    }

    public List<String> getList(){
        generateList();
        return recommendedList;
    }


}
