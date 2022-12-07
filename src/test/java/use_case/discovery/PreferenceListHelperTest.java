package use_case.discovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case_discovery.PreferenceListHelper;
import java.util.Arrays;
import java.util.List;



public class PreferenceListHelperTest {

    PreferenceListHelper plh;

    @BeforeEach
    public void setUp() {
        plh = new PreferenceListHelper();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("author", "chen", "oliver",
                "eric", "heyy", "jack", "leo", "ming", "nick", "gavin", "henry",
                "ian", "ben", "daniel", "finch");
        List<String> generatedList = plh.getList();
        Assertions.assertEquals(correctList, generatedList);

    }


}