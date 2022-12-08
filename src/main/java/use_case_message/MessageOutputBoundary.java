package use_case_message;

public interface MessageOutputBoundary {
    void create(MessageResponseModel responseModel);
    void update(MessageResponseModel responseModel);
}
