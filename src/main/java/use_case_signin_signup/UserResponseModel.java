package use_case_signin_signup;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class UserResponseModel implements UserOutputBoundary {
    private String username;
    private String name;
    private String password;
    private Map<String, Object> userSettings;
    private List<Double> location;
    private List<Object> userInfo;

    public UserResponseModel() {
        this.userInfo = new ArrayList<>();
        this.userSettings = new HashMap<>();
    }

    public void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.location = location;
        this.userSettings.put("age", age);
        this.userSettings.put("income", income);
        this.userSettings.put("maritalStatus", maritalStatus);
        this.userSettings.put("pet", pet);
        this.userSettings.put("relationshipType", relationshipType);
        this.userSettings.put("gender", gender);
    }

    public ArrayList<Object> getInfo() {
        this.userInfo.add(username);
        this.userInfo.add(name);
        this.userInfo.add(password);
        this.userInfo.add(location);
        this.userInfo.add(userSettings);
        return (ArrayList<Object>) this.userInfo;
    }
}
