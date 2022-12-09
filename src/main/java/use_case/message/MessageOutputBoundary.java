package use_case.message;

public interface MessageOutputBoundary {
    void create(MessageResponseModel responseModel);
    void update(MessageResponseModel responseModel);
}
