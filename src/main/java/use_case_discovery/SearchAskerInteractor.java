package use_case_discovery;

public class SearchAskerInteractor implements DiscoveryInputBoundary {
    private SearchAskResponseModel responseModel;

    // private SearchQuestionRequestModel model;


    // private SearchQuestionPanelInterface panel;

    private final SearchQuestionPresenter dPanel;

    public SearchAskerInteractor(SearchQuestionPresenter dPanel){
        this.dPanel = dPanel;
        this.responseModel = new SearchAskResponseModel();
    }

    public void create(){

        responseModel.setIncomeQuestion("Range of Income (in unit of k)");
        responseModel.setAgeQuestion("Range of Age(0-100)");// 2
        responseModel.setMarriageQuestion("What marriage status are you looking for?");//3
        responseModel.setMarriageOption("Single,Divorce,Married".split(","));//4
        responseModel.setHobbyQuestion("What are the hobbies you want them to have?"); //5
        responseModel.setHobbyOption("Sport,Art,Music,Game,Movie,Cook,Read".split(","));//6
        responseModel.setRelationshipQuestion("Which type of relationship are you looking for?");//7
        responseModel.setRelationshipOption("Friend,One-Night,Long-term,Short-term,Doesn't Care".split(","));//8
        responseModel.setPetQuestion("Do you want them to have pet?"); //9
        responseModel.setPetOption("Yes,No,Doesn't Care".split(","));//10

        dPanel.update(responseModel);

    }

}

