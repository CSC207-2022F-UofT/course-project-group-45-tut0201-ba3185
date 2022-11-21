package use_case_discovery;

import UI.SearchQuestionPanel;
import UI.SearchQuestionPanelInterface;

public class SearchQuestionRequestModel {
    private SearchQuestionPanelInterface panel;

    public void setPanel(SearchQuestionPanelInterface panel){
        this.panel = panel;
    }

    public SearchQuestionPanelInterface getPanel(){
        return panel;
    }
}
