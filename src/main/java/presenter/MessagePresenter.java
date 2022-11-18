package presenter;

// Use case layer

import use_case_chat.MessageResponseModel;

public interface MessagePresenter {
    MessageResponseModel prepareSuccessView(MessageResponseModel backMsg);
}