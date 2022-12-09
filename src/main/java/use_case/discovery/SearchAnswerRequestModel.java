package use_case.discovery;

/**
 * This is the requestModel that stores user's answer to each question.
 *
 */
public class SearchAnswerRequestModel {
    private int incomeUp;
    private int incomeLow;
    private int ageUp;
    private int ageLow;
    private int marriageStateOP;
    private int areaOfInterestOp;
    private int relationshipOp;
    private int petOp;

    public void setIncomeUp(int incomeUp){this.incomeUp = incomeUp;}
    public int getIncomeUp(){return incomeUp;}

    public void setIncomeLow(int incomeLow){this.incomeLow = incomeLow;}
    public int getIncomeLow(){return incomeLow;}

    public void setAgeUp(int ageUp){this.ageUp = ageUp;}
    public int getAgeUp(){return ageUp;}

    public void setAgeLow(int ageLow){this.ageLow = ageLow;}
    public int getAgeLow(){return ageLow;}

    public void setMarriageStateOP(int marriageStateOP){this.marriageStateOP = marriageStateOP;}
    public int getMarriageStateOP(){return marriageStateOP;}

    public void setAreaOfInterestOp(int areaOfInterestOp){this.areaOfInterestOp = areaOfInterestOp;}
    public int getAreaOfInterestOp(){return areaOfInterestOp;}

    public void setRelationshipOp(int relationshipOp){this.relationshipOp = relationshipOp;}
    public int getRelationshipOp(){return relationshipOp;}

    public void setPetOp(int petOp){this.petOp = petOp;}
    public int getPetOp(){return petOp;}


}

