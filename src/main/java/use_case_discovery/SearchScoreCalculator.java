package use_case_discovery;

import entity.User;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchScoreCalculator implements ScoreCalculator{
    private int score;
    private Map<String,String>  searchAnswers;

    public SearchScoreCalculator(Map<String,String> searchAnswers){
        this.searchAnswers = searchAnswers;
    }

    public void calculateScore(User user){
        int userIncome = (int) (user.getUserInfo("income"));
        int userAge = (int) user.getUserInfo("age");
        int incomeLow = Integer.parseInt(searchAnswers.get("incomeLow"));
        int incomeUp = Integer.parseInt(searchAnswers.get("incomeUp"));
        int ageLow = Integer.parseInt(searchAnswers.get("ageLow"));
        int ageUp = Integer.parseInt(searchAnswers.get("ageUp"));

        if(incomeLow < userIncome && userIncome < incomeUp){
            this.score = this.score + 1;
        }
        if(ageLow < userAge &&  userAge < ageUp){
            this.score = this.score + 1;
        }
        if(searchAnswers.get("marriageState").equals(user.getUserInfo("marriageState"))){
            this.score = this.score + 1;
        }
        if(searchAnswers.get("relationship").equals("Doesn't care") || searchAnswers.get("relationship").equals(user.getUserInfo("relationshipType"))){
            this.score = this.score + 1;
        }

        Boolean pet = (Boolean) convertB(searchAnswers.get("pet"));
        if(pet == null || pet.equals(user.getUserInfo("pet"))){
            this.score = this.score + 1;
        }
        if(searchAnswers.get("relationship").equals(user.getUserInfo("areaOfInterest"))) {
            this.score = this.score + 1;
        }
    }

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
