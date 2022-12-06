package use_case_signin_signup;
import java.util.List;
import java.util.Map;

public interface UserInputBoundary {
    public void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location, String sexualOrientation);

    public String getUsername();
    public String getName();
    public String getPassword();
    public List<Double> getLocation();
    public Map<String, Object> getUserSetting();
}