package use_case_message;

//interface adapter layer
public interface MessageOutputBoundary {
    MessageViewModel create(MessageResponseModel responseModel);
}
