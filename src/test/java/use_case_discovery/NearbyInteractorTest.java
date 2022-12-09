package use_case_discovery;

import database.csvManager;
import gui.discovery.UsersBtnPanel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.discovery.DiscoveryListInterface;
import use_case.discovery.DiscoveryResponseModel;
import use_case.discovery.nearBy.NearbyInteractor;

import java.util.*;

public class NearbyInteractorTest {
    // To test the use case:
    // 1) Create a NearbyInteractor and prerequisite objects
    //    (arguments for the NearbyInteractor constructor parameters)
    // 2) create the Input Data
    // 3) Call the use case DiscoveryInputBoundary method(creat()) to run the use case
    // 4) Check that the Output Data passed to the Presenter is correct
    // 5) Check that the expected changes to the data layer are there.

    NearbyInteractor ni;
    DiscoveryResponseModel drm;
    DiscoveryListInterface presenter = new UsersBtnPanel();
    @BeforeEach
    public void setUp(){
        csvManager manager = new csvManager();
        List<Double> location = new ArrayList<>(Arrays.asList(-79.39653244306562,43.66082236600782));
        List<String> interestRank = new ArrayList<>(Arrays.asList("income", "age", "marital status",
                "interests", "relationship type", "pet"));
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("gender", "male");
        userInfo.put("income", 124124);
        userInfo.put("age", 124124);
        userInfo.put("maritalStatus", "single");
        userInfo.put("relationshipType", "friend");
        userInfo.put("pet", "yes");
        userInfo.put("sexualOrientation", "male");
        manager.writeCurrentUser("sunny", "sunny", "sunny", location, userInfo, interestRank,
                "sport");
        ni = new NearbyInteractor(presenter);
    }
    @Test
    public void testCreat(){
        ni.create();
        drm = ni.dResponseModel;

        Assertions.assertEquals("ben", drm.getUserName1());
        Assertions.assertEquals("nick", drm.getUserName2());
        Assertions.assertEquals("ian", drm.getUserName3());
        Assertions.assertEquals("leo", drm.getUserName4());
        Assertions.assertEquals("gavin", drm.getUserName5());
        Assertions.assertEquals("chen", drm.getUserName6());
        Assertions.assertEquals("author", drm.getUserName7());
        Assertions.assertEquals("ming", drm.getUserName8());
        Assertions.assertEquals("eric", drm.getUserName9());
        Assertions.assertEquals("heyy", drm.getUserName10());
        Assertions.assertEquals("jack", drm.getUserName11());
        Assertions.assertEquals("daniel", drm.getUserName12());
        Assertions.assertEquals("henry", drm.getUserName13());
        Assertions.assertEquals("oliver", drm.getUserName14());
        Assertions.assertEquals("finch", drm.getUserName15());
    }

    @AfterAll
    public static void cleanup() {
        csvManager manager = new csvManager();
        manager.logoutUser();
    }
}

