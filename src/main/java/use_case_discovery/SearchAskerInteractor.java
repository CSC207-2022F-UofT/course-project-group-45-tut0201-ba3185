package use_case_discovery;

/**
 * This interactor is triggered by user clicking the search button.
 * It will generate the list of questions user need to answer and options
 * for some questions. It will store the question in responseModel and pass
 * to view to update the UI.
 */
public class SearchAskerInteractor implements DiscoveryInputBoundary {
    public SearchAskResponseModel sResponseModel;

    private final SearchQuestionInterface dPanel;

    /**
     * This constructor takes in a panel and use it later to call update method.
     * @param dPanel is the panel we need to update
     */

    public SearchAskerInteractor(SearchQuestionInterface dPanel){
        this.dPanel = dPanel;
    }

    public void create(){
        sResponseModel = new SearchAskResponseModel();

        sResponseModel.setIncomeQuestion("Range of Income (in unit of k)");
        sResponseModel.setAgeQuestion("Range of Age(0-100)");
        sResponseModel.setMarriageQuestion("What marriage status are you looking for?");
        sResponseModel.setMarriageOption("Single,Divorce,Married".split(","));
        sResponseModel.setHobbyQuestion("What are the hobbies you want them to have?");
        sResponseModel.setHobbyOption("Sport,Art,Music,Game,Movie,Cook,Read".split(","));
        sResponseModel.setRelationshipQuestion("Which type of relationship are you looking for?");
        sResponseModel.setRelationshipOption("Friend,One-Night,Long-term,Short-term,Doesn't Care".split(","));
        sResponseModel.setPetQuestion("Do you want them to have pet?");
        sResponseModel.setPetOption("Yes,No,Doesn't Care".split(","));

        dPanel.update(sResponseModel);

    }

}

