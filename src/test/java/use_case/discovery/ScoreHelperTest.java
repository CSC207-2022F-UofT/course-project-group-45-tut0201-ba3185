package use_case.discovery;

import org.junit.Before;
import org.junit.Test;
import use_case_discovery.ScoreHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ScoreHelperTest {
    ScoreHelper sh1;//no same score
    ScoreHelper sh2;//multiple same score
    Map<String, Integer> initialMap1 = new HashMap<>() {{
        put("momo",88);
        put("ian",29);
        put("amy",22);
        put("ben",9);
        put("kitty",11);
        put("chris",3);
        put("harry",1);
    }};
    Map<String, Integer> initialMap2 = new HashMap<>() {{
        put("momo",88);
        put("ian",29);
        put("amy",22);
        put("ben",9);
        put("mikey",88);
        put("kitty",11);
        put("chris",3);
        put("harry",1);
        put("jose",1);
    }};
    @Before
    public void setUp(){
        sh1 = new ScoreHelper(initialMap1);
        sh2 = new ScoreHelper(initialMap2);
    }
    @Test
    public void testSh1(){
        List<String> correct = Arrays.asList("momo", "ian", "amy", "kitty", "ben", "chris", "harry");
        assertEquals(correct, sh1.getList());
    }
    @Test
    public void testSh2(){
        List<String> correct = Arrays.asList("mikey", "momo", "ian", "amy", "kitty", "ben", "chris", "harry", "jose");
        assertEquals(correct, sh2.getList());
    }

}

