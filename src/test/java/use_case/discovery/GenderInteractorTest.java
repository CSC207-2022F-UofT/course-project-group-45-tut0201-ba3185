package use_case.discovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.GenderInteractor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GenderInteractorTest {
    GenderInteractor gi;

    @BeforeEach
    public void setUp() {
        gi = new GenderInteractor();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("heyy", "author", "ben","chen",
                "daniel","eric","finch","gavin","henry","ian","jack","leo","ming",
                "nick","oliver");
        Collections.sort(correctList);
        List<String> generatedList = gi.getList();
        Collections.sort(generatedList);
        Assertions.assertEquals(correctList, generatedList);

    }
}