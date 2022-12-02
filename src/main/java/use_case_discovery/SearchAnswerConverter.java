package use_case_discovery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAnswerConverter {
    private SearchAnswerRequestModel requestModel;
    private String marriageState;
    private String areaOfInterest;

    private String relationship;

    private Boolean pet;

    private Integer incomeLow;

    private Integer incomeUp;

    private Integer ageLow;

    private Integer ageUp;

    private Map<String,String> answerList;


    //constructor with parameter
    public SearchAnswerConverter(SearchAnswerRequestModel requestModel){
        this.requestModel = requestModel;
        System.out.println(requestModel.getIncomeLow() + "converter");
        answerList = new HashMap<>();
        store();

    }
    public void store(){
        incomeLow = requestModel.getIncomeLow();
        answerList.put("incomeLow", incomeLow.toString());
        incomeUp = requestModel.getIncomeUp();
        answerList.put("incomeUp", incomeUp.toString());
        covertMarriageStateOP();

        ageLow = requestModel.getAgeLow();
        answerList.put("ageLow", ageLow.toString());
        ageUp = requestModel.getAgeUp();
        answerList.put("ageUp", ageUp.toString());

        covertMarriageStateOP();
        answerList.put("marriageState",marriageState);
        convertAreaOfInterest();
        answerList.put("areaOfInterest",areaOfInterest);
        convertRelationship();
        answerList.put("relationship",relationship);
        convertPet();
        answerList.put("pet",pet.toString());

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
                pet = true;
                break;
            case 1:
                pet = false;
                break;
            case 2:
                pet = null;
                break;
        }
    }

    public Map<String, String> getAnswer(){
        return this.answerList;
    }
}
