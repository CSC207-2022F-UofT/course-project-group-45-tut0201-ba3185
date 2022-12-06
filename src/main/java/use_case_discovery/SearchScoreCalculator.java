package use_case_discovery;

import database.csvManager;
import entity.User;
import use_case_signin_signup.UserRequestModel;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This function help calculate the score of the user based on the answer user entered
 *
 */
public class SearchScoreCalculator implements ScoreCalculator{
    private int score;
    private Map<String,String>  searchAnswers;
    Map<String, UserRequestModel> otherUsers;
    UserAccess manager = new csvManager();

    public SearchScoreCalculator(Map<String,String> searchAnswers){
        this.searchAnswers = searchAnswers;

        try{
            this.otherUsers = manager.readUser();
        }
        catch (IOException exception){
            throw new RuntimeException(exception);
        };
    }


    public void calculateScore(String user){ // need to change to the actual user
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
        if(searchAnswers.get("marriageState").equals(userInfo.get("martialStatus"))){
            this.score = this.score + 1;
        }

        if(searchAnswers.get("relationship").equals("Doesn't care") ||
                searchAnswers.get("relationship").equals(userInfo.get("relationshipType"))){
            this.score = this.score + 1;
        }

        Boolean pet = (Boolean) convertB(searchAnswers.get("pet"));
        if(pet == null || pet.equals(userInfo.get("pet"))){
            this.score = this.score + 1;
        }
        if(searchAnswers.get("areaOfInterest").equals(userInfo.get("areaOfInterest"))) {
            this.score = this.score + 1;
        }
    }

    /**
     * This funciton convert the string petOP to the boolean pet Option
     * @param petOp a string of true false or null according to user's ansert
     * @return boolean petOp
     */
    public Object convertB(String petOp){
        if (petOp.equals("true")){
            return true;
        }
        if (petOp.equals("false")){
            return false;
        }
        return null;
    }
    @Override
    public int getScore() {
        return score;
    }
}
