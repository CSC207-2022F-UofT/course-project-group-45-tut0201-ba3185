package use_case_signin_signup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserOutputBoundary {
    public void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location, String sexualOrientation, String interestRank,
                        String areaOfInterest);
    public String getUsername();
    public String getName();
    public String getPassword();
    public List<Double> getLocation();
    public Map<String, Object> getUserSetting();
    public String getInterestRank();
    public String getAreaOfInterest();
}