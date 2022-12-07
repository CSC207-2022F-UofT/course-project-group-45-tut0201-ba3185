package use_case_discovery;

import gui.DiscoveryPanel;
import gui.discovery.UsersBtnPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.*;

import java.util.HashMap;
import java.util.Map;

public class SearchInteractorTest {

    static  DiscoveryListInterface pPanel;
    static DiscoveryResponseModel dResponseModel;
    static SearchInteractor interactor;
    static SearchAnswerRequestModel requestModel;


    @BeforeEach
    public void setUp(){
        pPanel = new UsersBtnPanel();
        interactor = new SearchInteractor(pPanel);
        requestModel = new SearchAnswerRequestModel();
    }

    @Test
    public void searchInteractorTest1(){
        requestModel.setAreaOfInterestOp(2); //music
        requestModel.setRelationshipOp(2); // long-term
        requestModel.setAgeLow(18);
        requestModel.setAgeUp(25);
        requestModel.setPetOp(1);// no
        requestModel.setIncomeLow(22);
        requestModel.setIncomeUp(50);
        requestModel.setMarriageStateOP(2);// married

        interactor.recommendListGenerator(requestModel);

        DiscoveryResponseModel model = interactor.dResponseModel;

        Assertions.assertEquals("ben",model.getUserName1());
        Assertions.assertEquals("jack",model.getUserName2());
        Assertions.assertEquals("nick",model.getUserName3());
        Assertions.assertEquals("chen",model.getUserName4());
        Assertions.assertEquals("gavin",model.getUserName5());
        Assertions.assertEquals("henry",model.getUserName6());
        Assertions.assertEquals("ian",model.getUserName7());
        Assertions.assertEquals("leo",model.getUserName8());
        Assertions.assertEquals("author",model.getUserName9());
        Assertions.assertEquals("daniel",model.getUserName10());
        Assertions.assertEquals("finch",model.getUserName11());
        Assertions.assertEquals("ming",model.getUserName12());
        Assertions.assertEquals("oliver",model.getUserName13());
        Assertions.assertEquals("eric",model.getUserName14());
        Assertions.assertEquals("heyy",model.getUserName15());

    }


    @Test
    public void searchInteractorTest2(){
        requestModel.setAreaOfInterestOp(0); //sport
        requestModel.setRelationshipOp(1); // one-night
        requestModel.setAgeLow(25);
        requestModel.setAgeUp(70);
        requestModel.setPetOp(0);// yes
        requestModel.setIncomeLow(5);
        requestModel.setIncomeUp(20);
        requestModel.setMarriageStateOP(0);// single

        interactor.recommendListGenerator(requestModel);

        DiscoveryResponseModel model = interactor.dResponseModel;

        Assertions.assertEquals("eric",model.getUserName1());
        Assertions.assertEquals("heyy",model.getUserName2());
        Assertions.assertEquals("oliver",model.getUserName3());
        Assertions.assertEquals("author",model.getUserName4());
        Assertions.assertEquals("gavin",model.getUserName5());
        Assertions.assertEquals("leo",model.getUserName6());
        Assertions.assertEquals("nick",model.getUserName7());
        Assertions.assertEquals("chen",model.getUserName8());
        Assertions.assertEquals("daniel",model.getUserName9());
        Assertions.assertEquals("finch",model.getUserName10());
        Assertions.assertEquals("henry",model.getUserName11());
        Assertions.assertEquals("ian",model.getUserName12());
        Assertions.assertEquals("ming",model.getUserName13());
        Assertions.assertEquals("ben",model.getUserName14());
        Assertions.assertEquals("jack",model.getUserName15());

    }

}