package use_case.signin_signup;

import java.util.*;

public class UserResponseModel implements UserOutputBoundary {
    private String username;
    private String name;
    private String password;
    private List<String> interestRank;
    private Map<String, Object> userSettings;
    private List<Double> location;
    private String areaOfInterest;

    public UserResponseModel() {
        this.userSettings = new HashMap<>();
    }

    public void setInfo(String username, String name, String password, int age, int income,
                        String gender, String relationshipType, String maritalStatus, String pet,
                        List<Double> location, String sexualOrientation, List<String> interestRank,
                        String areaOfInterest) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.location = location;
        this.interestRank = interestRank;
        this.areaOfInterest = areaOfInterest;
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