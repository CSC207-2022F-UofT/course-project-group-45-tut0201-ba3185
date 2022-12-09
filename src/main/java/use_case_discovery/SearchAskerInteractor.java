package use_case_discovery;

/**
 * This interactor is triggered by user clicking the search button.
 * It will generate the list of questions user need to answer and options
 * for some questions. It will store the question in responseModel and pass
 * to view to update the UI.
 */
public class SearchAskerInteractor implements DiscoveryInputBoundary {
    private final SearchAskResponseModel responseModel;

    private final SearchQuestionInterface dPanel;

    /**
     * This constructor takes in a panel and use it later to call update method.
     * @param dPanel is the panel we need to update
     */

    public SearchAskerInteractor(SearchQuestionInterface dPanel){
        this.dPanel = dPanel;
        this.responseModel = new SearchAskResponseModel();
    }

    public void create(){

        responseModel.setIncomeQuestion("Range of Income (in unit of k)");
        responseModel.setAgeQuestion("Range of Age(0-100)");
        responseModel.setMarriageQuestion("What marriage status are you looking for?");
        responseModel.setMarriageOption("Single,Divorce,Married".split(","));
        responseModel.setHobbyQuestion("What are the hobbies you want them to have?");
        responseModel.setHobbyOption("Sport,Art,Music,Game,Movie,Cook,Read".split(","));
        responseModel.setRelationshipQuestion("Which type of relationship are you looking for?");
        responseModel.setRelationshipOption("Friend,One-Night,Long-term,Short-term,Doesn't Care".split(","));
        responseModel.setPetQuestion("Do you want them to have pet?");
        responseModel.setPetOption("Yes,No,Doesn't Care".split(","));

        dPanel.update(responseModel);

    }

}

