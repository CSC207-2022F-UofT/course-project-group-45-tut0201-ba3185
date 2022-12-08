package use_case_discovery;

import database.csvInterface;
import database.csvManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;



public class PreferenceScoreCalculatorTest {
    PreferenceScoreCalculator psc1;//case of full mark(all the same)
    PreferenceScoreCalculator psc2;//case of zero mark(all different)
    PreferenceScoreCalculator psc3;//case of more than two matches(with bonus mark)
    PreferenceScoreCalculator psc4;//case of exactly two matches(without bonus mark)
    PreferenceScoreCalculator psc5;//case of exactly one matches(without bonus mark)

    csvInterface manager = new csvManager();
    List<String> cInterestRank = manager.readCurrentUser().getInterestRank();
    @BeforeEach
    public void setUp() {
        psc1 = new PreferenceScoreCalculator("author",cInterestRank);
        psc2 = new PreferenceScoreCalculator("finch",cInterestRank);
        psc3 = new PreferenceScoreCalculator("eric",cInterestRank);
        psc4 = new PreferenceScoreCalculator("ming",cInterestRank);
        psc5 = new PreferenceScoreCalculator("ian",cInterestRank);
    }
    @Test
    public void testPsc1(){
        Assertions.assertEquals(22, psc1.getScore());
    }
    @Test
    public void testPsc2(){
        Assertions.assertEquals(0, psc2.getScore());
    }
    @Test
    public void testPsc3(){
        Assertions.assertEquals(19, psc3.getScore());
    }
    @Test
    public void testPsc4(){
        Assertions.assertEquals(11, psc4.getScore());
    }
    @Test
    public void testPsc5(){
        Assertions.assertEquals(5, psc5.getScore());
    }

}