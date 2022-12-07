import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchListHelper;
import use_case_discovery.SearchScoreCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchListHelperTest {
    static SearchAnswerRequestModel requestModel;
    static SearchListHelper helper;


    @BeforeEach
    public void setUp(){
        requestModel = new SearchAnswerRequestModel();

    }

    @Test
    public void correctList1(){
        requestModel.setAreaOfInterestOp(2); //music
        requestModel.setRelationshipOp(2); // long-term
        requestModel.setAgeLow(18);
        requestModel.setAgeUp(25);
        requestModel.setPetOp(1);// no
        requestModel.setIncomeLow(22);
        requestModel.setIncomeUp(50);
        requestModel.setMarriageStateOP(2);// married
        helper = new SearchListHelper(requestModel);

        List<String> expected = Arrays.asList("ben","jack","nick","chen","gavin","henry","ian","leo",
                "author","daniel","finch","ming","oliver","eric","heyy");


        List<String> actual = helper.getList();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void correctList2(){
        requestModel.setAreaOfInterestOp(0); //sport
        requestModel.setRelationshipOp(1); // one-night
        requestModel.setAgeLow(25);
        requestModel.setAgeUp(70);
        requestModel.setPetOp(0);// yes
        requestModel.setIncomeLow(5);
        requestModel.setIncomeUp(20);
        requestModel.setMarriageStateOP(0);// single
        helper = new SearchListHelper(requestModel);

        List<String> expected = Arrays.asList("eric","heyy","oliver","author","gavin","leo",
                "nick","chen","daniel","finch","henry","ian","ming","ben","jack");


        List<String> actual = helper.getList();
        Assertions.assertEquals(expected, actual);

    }


}
