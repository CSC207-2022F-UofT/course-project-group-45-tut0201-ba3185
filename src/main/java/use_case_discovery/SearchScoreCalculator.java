package use_case_discovery;


import use_case_signin_signup.UserRequestModel;

import java.util.Map;

/**
 * This function help calculate the score of the user based on the answer user entered
 * It adds one to the score with each matching field.
 *
 */
public class SearchScoreCalculator extends csvInteractor implements ScoreCalculator{
    private int score;
    private final Map<String,String>  searchAnswers;
    Map<String, UserRequestModel> otherUsers;

    /**
     * The constructor takes search Answer as input and initialize the other user list
     * @param searchAnswers current user's answer to the search discovery question.
     */
    public SearchScoreCalculator(Map<String,String> searchAnswers){
        this.searchAnswers = searchAnswers;

       this.otherUsers = super.otherUsersInfo;
    }

    /**
     * This funciton takes username of the user and find the personal info of that user
     * then compare the info with the answer to generate a score.
     * @param user username of the user.
     */

    public void calculateScore(String user){

        score = 0;
        Map<String, Object> userInfo = otherUsers.get(user).getUserSetting();

        int userIncome = (int) userInfo.get("income");
        int userAge = (int) userInfo.get("age");
        int incomeLow = Integer.parseInt(searchAnswers.get("incomeLow"));
        int incomeUp = Integer.parseInt(searchAnswers.get("incomeUp"));
        int ageLow = Integer.parseInt(searchAnswers.get("ageLow"));
        int ageUp = Integer.parseInt(searchAnswers.get("ageUp"));

        if(incomeLow <= userIncome && userIncome <= incomeUp){
            this.score = this.score + 1;
        }
        if(ageLow <= userAge &&  userAge <= ageUp){
            this.score = this.score + 1;
        }

        String marriageState = searchAnswers.get("marriageState");

        if(marriageState.equals(userInfo.get("maritalStatus"))){

            this.score = this.score + 1;
        }

        if(searchAnswers.get("relationship").equals("Doesn't care") ||
                searchAnswers.get("relationship").equals(userInfo.get("relationshipType"))){
            this.score = this.score + 1;
        }

        String pet = searchAnswers.get("pet");
        if(pet.equals("doesn't care") || pet.equals(userInfo.get("pet"))){
            this.score = this.score + 1;
        }
        if(searchAnswers.get("areaOfInterest").equals(otherUsers.get(user).getAreaOfInterest())) {
            this.score = this.score + 1;
        }
    }

    /**
     * this return the score of the user.
     * @return the integer score of the user.
     */
    @Override
    public int getScore() {
        return score;
    }
}
