package use_case.discovery.search;

/**
 * This is the response model that store the questions generated from the searchAnswerInteractor
 */
public class SearchAskResponseModel {
        private String incomeQuestion;
        private String ageQuestion;
        private String marriageQuestion;
        private String[] marriageOption;
        private String hobbyQuestion;
        private String[] hobbyOption;
        private String relationshipQuestion;
        private String[] relationshipOption;
        private String petQuestion;
        private String[] petOption;
        public void setIncomeQuestion(String incomeQuestion){this.incomeQuestion = incomeQuestion;}

        public String getIncomeQuestion(){return incomeQuestion;}

        public void setAgeQuestion(String ageQuestion){this.ageQuestion = ageQuestion;}

        public String getAgeQuestion(){return ageQuestion;}

        public void setMarriageQuestion(String marriageQuestion){this.marriageQuestion = marriageQuestion;}

        public String getMarriageQuestion(){return marriageQuestion;}

        public void setMarriageOption(String[] marriageOption){this.marriageOption = marriageOption;}

        public String[] getMarriageOption(){return marriageOption;}


        public void setHobbyQuestion(String hobbyQuestion){this.hobbyQuestion = hobbyQuestion;}

        public String getHobbyQuestion(){return hobbyQuestion;}


        public void setHobbyOption(String[] hobbyOption){this.hobbyOption = hobbyOption;}

        public String[] getHobbyOption(){return hobbyOption;}


        public void setRelationshipQuestion(String relationshipQuestion){this.relationshipQuestion = relationshipQuestion;}

        public String getRelationshipQuestion(){return relationshipQuestion;}

        public void setRelationshipOption(String[] relationshipOption){this.relationshipOption = relationshipOption;}

        public String[] getRelationshipOption(){return relationshipOption;}


        public void setPetQuestion(String petQuestion){this.petQuestion = petQuestion;}

        public String getPetQuestion(){return petQuestion;}

        public void setPetOption(String[] petOption){this.petOption = petOption;}

        public String[] getPetOption(){return petOption;}

    }

