package use_case_message;

//interface adapter layer
public interface MessageOutputBoundary {
    void create(MessageResponseModel responseModel);
    void update(MessageResponseModel responseModel);
}
