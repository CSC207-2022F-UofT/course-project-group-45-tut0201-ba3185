import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_case_discovery.SearchScoreCalculator;
import use_case_discovery.UserForTest;
import static org.junit.Assert.*;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;
/**
 * Test suite for the DiscoverySearchTest use case, using different user answers to the search question
 * to check if it calculates the
 *
 * @author Christina Lan
 * @version 1.0
 * @since Dec 4th, 2022
 */

public class SearchScoreCalculatorTest {

    static UserForTest user1;
    static UserForTest user2;
    static UserForTest user3;
    static UserForTest user4;
    static UserForTest user5;
    static UserForTest user6;
    static HashMap<String, String> answerList;

    @BeforeAll
    public static void setUp(){
        user1 = new UserForTest("cami", "cami", "111", "Female", "Male",
                7, 27, true, "Short-term", "Married", "Art");
        user2 = new UserForTest("chris", "chris", "222", "Female", "Male",
                10, 40, true, "One-Night", "Divorce", "Game");
        user3 = new UserForTest("amber", "amber", "333", "Female", "Male",
                18, 70, false, "Long-term", "Single", "Sport");
        user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female",
                6, 19, false, "Short-term", "Single", "Music");
        user5 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male",
                12, 21, false, "Long-term", "Single", "Music");
        answerList = new HashMap<>();
        answerList.put("incomeLow", "8");
        answerList.put("incomeUp", "13");
        answerList.put("ageLow", "18");
        answerList.put("ageUp", "25");
        answerList.put("marriageState", "Single");
        answerList.put("relationship", "Long-term");
        answerList.put("pet", "false");
        answerList.put("areaOfInterest", "Music");
    }

    @Test
    public void noMatchCase(){
        SearchScoreCalculator calculator = new SearchScoreCalculator(answerList);
        calculator.calculateScore(user1);
        int actual = calculator.getScore();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void oneMatchCase(){
        SearchScoreCalculator calculator = new SearchScoreCalculator(answerList);
        calculator.calculateScore(user2);
        int actual = calculator.getScore();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void twoMatchCase(){
        SearchScoreCalculator calculator = new SearchScoreCalculator(answerList);
        calculator.calculateScore(user3);
        int actual = calculator.getScore();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multipleMatchCase(){
        SearchScoreCalculator calculator = new SearchScoreCalculator(answerList);
        calculator.calculateScore(user4);
        int actual = calculator.getScore();
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void allMatchCase(){
        SearchScoreCalculator calculator = new SearchScoreCalculator(answerList);
        calculator.calculateScore(user5);
        int actual = calculator.getScore();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }

}
