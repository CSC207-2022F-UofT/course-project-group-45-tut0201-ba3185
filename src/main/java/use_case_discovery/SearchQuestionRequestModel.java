package use_case_discovery;

import gui.SearchQuestionPanelInterface;

public class SearchQuestionRequestModel {
    private SearchQuestionPanelInterface panel;

    public void setPanel(SearchQuestionPanelInterface panel){
        this.panel = panel;
    }

    public SearchQuestionPanelInterface getPanel(){
        return panel;
    }
}
