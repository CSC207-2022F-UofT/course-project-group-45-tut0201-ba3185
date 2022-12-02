package use_case_chatScreen_test;

import database.csvManager;
import entity.ChatHistory;
import org.junit.Test;
import presenter.MessagePresenter;
import use_case_message.MessageManagers;
import org.junit.jupiter.api.Assertions;
import use_case_message.*;


class MessageInteractorUnitTest {
   @Test
   void create(){
       csvManager.readCurrentUser("src/main/java/database/currentUser.csv");
       MessagePresenter messagePresenter;
       MessageManagerFactory chatFactory;
       String msg = new String("Hello your test is running successfully");

       @Override
       public void create(MessageRequestModel requestModel){
            assertEqual("")
       }


   }

}
