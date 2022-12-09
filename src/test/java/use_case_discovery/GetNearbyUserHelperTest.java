package use_case_discovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class GetNearbyUserHelperTest {
    GetNearbyUserHelper helper;

    @BeforeEach
    public void setUp() {
        helper = new GetNearbyUserHelper();
    }


    @Test
    public void testGetList(){
        List<String> correctList = Arrays.asList("ben", "nick", "ian",
                "leo", "gavin", "chen", "author", "ming", "eric", "heyy", "jack",
                "daniel", "henry", "oliver", "finch");
        List<String> generatedList = helper.getList();
        Assertions.assertEquals(correctList, generatedList);

    }


}

