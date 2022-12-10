package use_case.discovery.search;

import use_case.discovery.search.SearchAnswerRequestModel;

public interface SearchInputBoundary {

    void recommendListGenerator(SearchAnswerRequestModel model);

}
