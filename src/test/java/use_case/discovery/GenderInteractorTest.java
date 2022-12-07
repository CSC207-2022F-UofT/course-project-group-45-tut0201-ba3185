package use_case.discovery;

import org.junit.Before;
import org.junit.Test;
import use_case_discovery.GenderInteractor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenderInteractorTest {
    GenderInteractor gi;

    @Before
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
        assertEquals(correctList, generatedList);

    }
}