import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.SearchAnswerConverter;
import use_case_discovery.SearchAnswerRequestModel;

import java.util.HashMap;
import java.util.Map;

public class SearchAnswerConverterTest {

    SearchAnswerRequestModel requestModel;


    @BeforeEach
    public void setUp(){
        requestModel = new SearchAnswerRequestModel();
    }

    @Test
    public void convertOptionWithAllZero(){
        requestModel.setIncomeLow(8);
        requestModel.setIncomeUp(20);
        requestModel.setAgeLow(18);
        requestModel.setAgeUp(30);
        requestModel.setRelationshipOp(0);
        requestModel.setPetOp(0);
        requestModel.setAreaOfInterestOp(0);
        requestModel.setMarriageStateOP(0);
        SearchAnswerConverter converter = new SearchAnswerConverter(requestModel);
        converter.store();
        Map<String,String> expected = new HashMap<>();
        expected.put("incomeLow", "8");
        expected.put("incomeUp","20");
        expected.put("ageLow","18");
        expected.put("ageUp","30");
        expected.put("marriageState","single");
        expected.put("areaOfInterest","sport");
        expected.put("relationship","friend");
        expected.put("pet","yes");

        Assertions.assertEquals(expected, converter.getAnswer());


    }
    @Test
    public void convertOptionWithDifferentOption(){
        requestModel.setIncomeLow(8);
        requestModel.setIncomeUp(20);
        requestModel.setAgeLow(17);
        requestModel.setAgeUp(21);
        requestModel.setRelationshipOp(1);
        requestModel.setPetOp(1);
        requestModel.setAreaOfInterestOp(3);
        requestModel.setMarriageStateOP(2);
        SearchAnswerConverter converter = new SearchAnswerConverter(requestModel);
        converter.store();
        Map<String,String> expected1 = new HashMap<>();
        expected1.put("incomeLow", "8");
        expected1.put("incomeUp","20");
        expected1.put("ageLow","17");
        expected1.put("ageUp","21");
        expected1.put("marriageState","married");
        expected1.put("areaOfInterest","game");
        expected1.put("relationship","one-night");
        expected1.put("pet","no");

        Assertions.assertEquals(expected1, converter.getAnswer());

    }

    @Test
    public void convertOptionWithLastOption(){
        requestModel.setIncomeLow(11);
        requestModel.setIncomeUp(22);
        requestModel.setAgeLow(17);
        requestModel.setAgeUp(21);
        requestModel.setRelationshipOp(4);
        requestModel.setPetOp(2);
        requestModel.setAreaOfInterestOp(6);
        requestModel.setMarriageStateOP(2);

        SearchAnswerConverter converter = new SearchAnswerConverter(requestModel);
        converter.store();
        Map<String,String> expected2 = new HashMap<>();
        expected2.put("incomeLow", "11");
        expected2.put("incomeUp","22");
        expected2.put("ageLow","17");
        expected2.put("ageUp","21");
        expected2.put("marriageState","married");
        expected2.put("areaOfInterest","read");
        expected2.put("relationship","doesn't care");
        expected2.put("pet","doesn't care");

        Assertions.assertEquals(expected2, converter.getAnswer());

    }



}
