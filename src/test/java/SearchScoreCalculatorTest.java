import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.ScoreHelper;
import use_case_discovery.SearchAnswerConverter;
import use_case_discovery.SearchAnswerRequestModel;
import use_case_discovery.SearchScoreCalculator;

import java.util.HashMap;
import java.util.Map;

public class SearchScoreCalculatorTest {

    static SearchScoreCalculator calculator;

    static HashMap<String, String> answerList;

    @BeforeAll
    static public void setUp(){
        answerList = new HashMap<>();
        answerList.put("incomeLow", "22");
        answerList.put("incomeUp", "50");
        answerList.put("ageLow", "18");
        answerList.put("ageUp", "25");
        answerList.put("marriageState", "married");
        answerList.put("relationship", "long-term");
        answerList.put("pet", "no");
        answerList.put("areaOfInterest", "music");
        calculator = new SearchScoreCalculator(answerList);

    }

    @Test
    public void userWithZeroMatch(){
        String user = "heyy";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void userWithOneMatch(){
        String user = "author";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void userWithTwoMatch(){
        String user = "gavin";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void userWithThreeMatch(){
        String user = "nick";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 3;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void userWithTFourMatch(){
        String user = "jack";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 4;
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void userWithFiveMatch(){
        String user = "yoyo";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 5;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void userWithAllMatch(){
        String user = "jenny";
        calculator.calculateScore(user);
        int actual = calculator.getScore();
        int expected = 6;
        Assertions.assertEquals(expected, actual);

    }



}
