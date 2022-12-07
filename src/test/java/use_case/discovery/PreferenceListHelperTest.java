package use_case.discovery;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class PreferenceListHelperTest {

    PreferenceListHelper plh;

    @Before
    public void setUp() {
        plh = new PreferenceListHelper();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("author", "chen", "oliver",
                "eric", "heyy", "jack", "leo", "ming", "nick", "gavin", "henry",
                "ian", "ben", "daniel", "finch");
        List<String> generatedList = plh.getList();
        assertEquals(correctList, generatedList);

    }


}