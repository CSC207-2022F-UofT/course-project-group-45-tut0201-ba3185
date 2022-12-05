package use_case_discovery;

import java.util.HashMap;
import java.util.Map;

/**
 * This class convert users answer from integer to the corresponding string
 *
 */
public class SearchAnswerConverter {
    private final SearchAnswerRequestModel requestModel;
    private String marriageState;
    private String areaOfInterest;

    private String relationship;

    private String pet;

    private final Map<String,String> answerList;

    public SearchAnswerConverter(SearchAnswerRequestModel requestModel){
        this.requestModel = requestModel;
        answerList = new HashMap<>();
        store();

    }
    public void store(){
        int incomeLow = requestModel.getIncomeLow();
        answerList.put("incomeLow", Integer.toString(incomeLow));
        int incomeUp = requestModel.getIncomeUp();
        answerList.put("incomeUp", Integer.toString(incomeUp));
        covertMarriageStateOP();

        int ageLow = requestModel.getAgeLow();
        answerList.put("ageLow", Integer.toString(ageLow));
        int ageUp = requestModel.getAgeUp();
        answerList.put("ageUp", Integer.toString(ageUp));

        covertMarriageStateOP();
        answerList.put("marriageState",marriageState);
        convertAreaOfInterest();
        answerList.put("areaOfInterest", areaOfInterest);
        convertRelationship();
        answerList.put("relationship",relationship);
        convertPet();
        answerList.put("pet",pet);

    }

    public void covertMarriageStateOP() {
        switch (requestModel.getMarriageStateOP()) {
            case 0:
                marriageState = "Single";
                break;
            case 1:
                marriageState = "Divorce";
                break;
            case 2:
                marriageState = "Married";
                break;
        }
    }

    public void convertAreaOfInterest() {
        switch (requestModel.getAreaOfInterestOp()) {
            case 0:
                areaOfInterest = "Sport";
                break;
            case 1:
                areaOfInterest = "Art";
                break;
            case 2:
                areaOfInterest = "Music";
                break;
            case 3:
                areaOfInterest = "Game";
                break;
            case 4:
                areaOfInterest = "Movie";
                break;
            case 5:
                areaOfInterest = "Cook";
                break;
            case 6:
                areaOfInterest = "Read";
                break;
        }
    }

    public void convertRelationship() {
        switch (requestModel.getRelationshipOp()) {
            case 0:
                relationship = "Friend";
                break;
            case 1:
                relationship = "One-Night";
                break;
            case 2:
                relationship = "Long-term";
                break;
            case 3:
                relationship = "Short-term";
                break;
            case 4:
                relationship = "Doesn't care";
                break;
        }
    }

    public void convertPet() {
        switch (requestModel.getPetOp()) {
            case 0:
                pet = "true";
                break;
            case 1:
                pet = "false";
                break;
            case 2:
                pet = "null";
                break;
        }
    }

    public Map<String, String> getAnswer(){
        return this.answerList;
    }
}
