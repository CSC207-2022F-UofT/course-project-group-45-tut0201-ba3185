package use_case_signin_signup;

import java.util.*;

public class UserRequestModel implements UserInputBoundary {
    private String username;
    private String name;
    private String password;
    private Map<String, Object> userSettings;
    private List<Double> location;
    private List<String> interestRank;
    private String areaOfInterest;

    public UserRequestModel() {
        this.userSettings = new HashMap<>();
    }

    public void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location, String sexualOrientation, List<String> interestRank,
                        String areaOfInterst) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.location = location;
        this.interestRank = interestRank;
        this.areaOfInterest = areaOfInterst;
        this.userSettings.put("age", age);
        this.userSettings.put("income", income);
        this.userSettings.put("maritalStatus", maritalStatus);
        this.userSettings.put("pet", pet);
        this.userSettings.put("relationshipType", relationshipType);
        this.userSettings.put("gender", gender);
        this.userSettings.put("sexualOrientation", sexualOrientation);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public List<Double> getLocation() {
        return this.location;
    }

    @Override
    public Map<String, Object> getUserSetting() {
        return this.userSettings;
    }

    @Override
    public List<String> getInterestRank() {
        return this.interestRank;
    }

    @Override
    public String getAreaOfInterest() {
        return this.areaOfInterest;
    }
}
