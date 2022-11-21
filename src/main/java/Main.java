import use_case_message.MessageManagers;
import gui.MainFrame;
import presenter.MessagePresenter;
import use_case_message.*;

public class Main {

    public static void main(String[] args) {
        //set up main frame
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);


        //plug in entity+use case engine
        MessageManagerFactory messageManagerFactory = new MessageManagerFactory();
        MessageOutputBoundary messagePresenter = new MessagePresenter(false);
        MessageManagers mms = new MessageManagers();
        MessageInputBoundary messageInteractor = new MessageInteractor(messagePresenter,messageManagerFactory, mms);
        //MessageController controller = new MessageController();
        //messageInteractor.create(controller.);

        // building our UI screens
        //ChatScreen c1 = new ChatScreen();

    }
}