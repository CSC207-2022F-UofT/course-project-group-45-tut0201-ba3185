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
                marriageState = "single";
                break;
            case 1:
                marriageState = "divorce";
                break;
            case 2:
                marriageState = "married";
                break;
        }
    }

    public void convertAreaOfInterest() {
        switch (requestModel.getAreaOfInterestOp()) {
            case 0:
                areaOfInterest = "sport";
                break;
            case 1:
                areaOfInterest = "art";
                break;
            case 2:
                areaOfInterest = "music";
                break;
            case 3:
                areaOfInterest = "game";
                break;
            case 4:
                areaOfInterest = "movie";
                break;
            case 5:
                areaOfInterest = "cook";
                break;
            case 6:
                areaOfInterest = "read";
                break;
        }
    }

    public void convertRelationship() {
        switch (requestModel.getRelationshipOp()) {
            case 0:
                relationship = "friend";
                break;
            case 1:
                relationship = "one-night";
                break;
            case 2:
                relationship = "long-term";
                break;
            case 3:
                relationship = "short-term";
                break;
            case 4:
                relationship = "doesn't care";
                break;
        }
    }

    public void convertPet() {
        switch (requestModel.getPetOp()) {
            case 0:
                pet = "yes";
                break;
            case 1:
                pet = "no";
                break;
            case 2:
                pet = "doesn't care";
                break;
        }
    }

    public Map<String, String> getAnswer(){
        return this.answerList;
    }
}
