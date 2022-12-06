package use_case.signin_signup;
import java.util.List;
import java.util.Map;

public interface UserInputBoundary {
    void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location, String sexualOrientation, List<String> interestRank,
                        String areaOfInterest);

    String getUsername();
    String getName();
    String getPassword();
    List<Double> getLocation();
    Map<String, Object> getUserSetting();
    List<String> getInterestRank();
    String getAreaOfInterest();
}