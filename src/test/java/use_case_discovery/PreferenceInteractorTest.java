package use_case_discovery;

import gui.discovery.UsersBtnPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PreferenceInteractorTest {
    // To test the use case:
    // 1) Create a PreferenceInteractor and prerequisite objects
    //    (arguments for the PreferenceInteractor constructor parameters)
    // 2) create the Input Data
    // 3) Call the use case DiscoveryInputBoundary method(creat()) to run the use case
    // 4) Check that the Output Data passed to the Presenter is correct
    // 5) Check that the expected changes to the data layer are there.

    PreferenceInteractor pi;
    DiscoveryResponseModel drm;
    DiscoveryListInterface presenter = new UsersBtnPanel();
    @BeforeEach
    public void setUp(){
        pi = new PreferenceInteractor(presenter);
    }
    @Test
    public void testCreat(){
        pi.create();
        drm = pi.dResponseModel;

        Assertions.assertEquals("author", drm.getUserName1());
        Assertions.assertEquals("chen", drm.getUserName2());
        Assertions.assertEquals("oliver", drm.getUserName3());
        Assertions.assertEquals("eric", drm.getUserName4());
        Assertions.assertEquals("heyy", drm.getUserName5());
        Assertions.assertEquals("jack", drm.getUserName6());
        Assertions.assertEquals("leo", drm.getUserName7());
        Assertions.assertEquals("ming", drm.getUserName8());
        Assertions.assertEquals("nick", drm.getUserName9());
        Assertions.assertEquals("gavin", drm.getUserName10());
        Assertions.assertEquals("henry", drm.getUserName11());
        Assertions.assertEquals("ian", drm.getUserName12());
        Assertions.assertEquals("ben", drm.getUserName13());
        Assertions.assertEquals("daniel", drm.getUserName14());
        Assertions.assertEquals("finch", drm.getUserName15());
    }



}