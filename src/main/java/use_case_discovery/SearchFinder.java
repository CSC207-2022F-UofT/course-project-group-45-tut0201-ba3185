package use_case_discovery;



import User.User;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchFinder implements SearchFinderInputBoundary {

    private DiscoveryListOutputBoundary presenter;
    private ArrayList<User> searchList;
    private SearchAnswerRequestModel requestModel;
    private String marriageState;
    private String areaOfInterest;

    private String relationship;

    private Boolean pet;

    //constructor with parameter
    public SearchFinder(SearchAnswerRequestModel requestModel, DiscoveryListOutputBoundary presenter){
        this.requestModel = requestModel;
        this.presenter = presenter;
        covertMarriageStateOP();
        convertAreaOfInterest();
        convertRelationship();
        convertPet();
    }

    public void covertMarriageStateOP() {
        switch (requestModel.getMarriageStateOP()) {
            case 1:
                marriageState = "Single";
                break;
            case 2:
                marriageState = "Divorce";
                break;
            case 3:
                marriageState = "Married";
                break;
        }
    }

    public void convertAreaOfInterest() {
        switch (requestModel.getAreaOfInterestOp()) {
            case 1:
                areaOfInterest = "Sport";
                break;
            case 2:
                areaOfInterest = "Art";
                break;
            case 3:
                areaOfInterest = "Music";
                break;
            case 4:
                areaOfInterest = "Game";
                break;
            case 5:
                areaOfInterest = "Movie";
                break;
            case 6:
                areaOfInterest = "Cook";
                break;
            case 7:
                areaOfInterest = "Read";
                break;
        }
    }

    public void convertRelationship() {
        switch (requestModel.getRelationshipOp()) {
            case 1:
                relationship = "Friend";
                break;
            case 2:
                relationship = "One-Night";
                break;
            case 3:
                relationship = "Long-term";
                break;
            case 4:
                relationship = "Short-term";
                break;
            case 5:
                relationship = "Doesn't care";
                break;
        }
    }

    public void convertPet() {
        switch (requestModel.getPetOp()) {
            case 1:
                pet = true;
                break;
            case 2:
                pet = false;
                break;
            case 3:
                pet = null;
                break;
        }
    }

    GenderFinder tempGenderFinder = new GenderFinder();

    ArrayList<User> userList = tempGenderFinder.genderSuitFinder;

    // helper
    public int getScore(User user){

        int score = 0;
        if(requestModel.getIncomeLow() <= user.getUserInfo("income") <= requestModel.getIncomeUp()){
            score = score + 1;
        }
        if(requestModel.getIncomeLow() <= user.getUserInfo("age") <= requestModel.getIncomeUp()){
            score = score + 1;
        }
        if(marriageState.equals(user.getUserInfo("marriageState"))){
            score = score + 1;
        }
        if(relationship.equals("Doesn't care") || relationship.equals(user.getUserInfo("relationship"))){
            score = score + 1;
        }
        if(pet.equals(null) || pet.equals(user.getUserInfo("pet"))){
            score = score + 1;
        }
        if(areaOfInterest.equals(user.getUserInfo("areaOfInterest"))){
            score = score + 1;
        }
        return score;
    }

    public void recommendListGenerator(){
        HashMap<User, Integer> UserListWithScore = new HashMap<User, Integer>();

        for(User user: userList){
            UserListWithScore.put(User, getScore(User));
        }


        // use the helper function and this will return a sorted list with list of username and score
        PreferenceScoreHelper preferenceScoreHelper = new PreferenceScoreHelper(userList);
        ArrayList<User> recommendList = preferenceScoreHelper.getList(); // return a list

        //call presenter

        presenter.displayList(0, recommendList);


    }

}
