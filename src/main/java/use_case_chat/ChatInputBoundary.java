package use_case_chat;

public interface ChatInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}
