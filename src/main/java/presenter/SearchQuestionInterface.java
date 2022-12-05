package presenter;

import use_case_discovery.SearchAskResponseModel;

/**
 * Interface for the search question UI
 */
public interface SearchQuestionInterface {
    void update(SearchAskResponseModel sResponseModel);
}
