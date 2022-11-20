package presenter;

import UI.SearchAskerViewModel;
import UI.SearchQuestionPanelInterface;
import use_case_discovery.SearchAskResponseModel;
import use_case_discovery.SearchAskerOutputBoundary;

import java.util.ArrayList;

public class SearchPresenter implements SearchAskerOutputBoundary {
    private SearchAskResponseModel responseModel;

    private ArrayList<String> question;

    private SearchAskerViewModel viewModel = new SearchAskerViewModel();

    private SearchQuestionPanelInterface panel;

   public SearchPresenter(SearchQuestionPanelInterface panel, SearchAskResponseModel responseModel){
        this.panel = panel;
        this.responseModel = responseModel;
    }

    public void displayQuestion(){
        // panel = new SearchQuestionPanel();
        // responseModel = new SearchAskResponseModel();
        this.question = responseModel.getSearchQuestion();
        viewModel.setIncomeQuestion(question.get(0));
        viewModel.setAgeQuestion(question.get(1));
        viewModel.setMarriageQuestion(question.get(2));
        viewModel.setMarriageOption(question.get(3).split(","));
        viewModel.setHobbyQuestion(question.get(4));
        viewModel.setHobbyOption(question.get(5).split(","));
        viewModel.setRelationshipQuestion(question.get(6));
        viewModel.setRelationshipOption(question.get(7).split(","));
        viewModel.setPetQuestion(question.get(8));
        viewModel.setPetOption(question.get(9).split(","));

        int FRAME_WIDTH = 414;
        int FRAME_HEIGHT = 736;
        panel.update(FRAME_WIDTH,FRAME_HEIGHT, viewModel);

    }
}
