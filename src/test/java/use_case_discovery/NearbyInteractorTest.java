package use_case_discovery;

import gui.discovery.UsersBtnPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}

