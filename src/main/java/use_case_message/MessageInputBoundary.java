package use_case_message;

public interface MessageInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}
