package use_case_message;

import database.MessageDataManager;
import database.csvManager;
import use_case_signin_signup.UserRequestModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MessageInteractor implements MessageInputBoundary {
    /**
     * The interactor for chat page that processes the request model to update the
     * chat history and creates a response model which is passed to the presenter to
     * update the view (load the message).
     */
    final MessageOutputBoundary messageOutputBoundary;
    final MessageManagerFactory chatFactory;
    MessageManagers messageManagers = new MessageManagers();
    MessageDataManager messageDataManager = new MessageDataManager();

    public MessageInteractor(MessageOutputBoundary messageOutputBoundary,
                             MessageManagerFactory chatFactory) {
        if (messageDataManager.readMM() != null){
            messageManagers = messageDataManager.readMM();
        }
        // This will throw an error at the very first time running the program since there is no such
        // file at first.
        this.messageOutputBoundary = messageOutputBoundary;
        this.chatFactory = chatFactory;
    }

    @Override
    public void create(MessageRequestModel requestModel) {
        try{
            csvManager manager = new csvManager();
            UserRequestModel model = manager.readCurrentUser();
            String user1 = model.getUsername();
            String user2 = requestModel.getTarget();
            MessageManager mm;

            // get the prior MessageManager or create a new one if there's no prior one
            if (messageManagers.find(user1, user2) != null){
                mm = messageManagers.find(user1, user2);
            }
            else{
                mm = chatFactory.create(user1, user2);
                messageManagers.addMM(mm);
            }

            SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String msg = requestModel.getMsg();
            if(msg != null){ // if the message is not null, update it onto the screen
                mm.SaveChatHistory(now.format(timestamp), user1, msg); //record the new message
                MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());
                messageOutputBoundary.update(messageResponseModel);
            }
            else {
                // if the message is null, load all chat history
                MessageResponseModel messageResponseModel = new MessageResponseModel(mm.getChatHistory());
                messageOutputBoundary.create(messageResponseModel);
            }
            messageDataManager.writeMM(messageManagers);
        }
        catch (NullPointerException exception){
            throw new RuntimeException("Current user not found. Please log in.");
        }
    }
}
