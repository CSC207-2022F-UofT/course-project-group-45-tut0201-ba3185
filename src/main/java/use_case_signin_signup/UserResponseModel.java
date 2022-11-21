package use_case_signin_signup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserResponseModel implements UserOutputBoundary {
    private String username;
    private String name;
    private String password;
    private int age;
    private int income;
    private String gender;
    private String pet;
    private String maritalStatus;
    private String relationshipType;
    private ArrayList<Double> location;

    private ArrayList<Object> userInfo;

    public UserResponseModel() {
        this.userInfo = new ArrayList<>();
    }

    public void setInfo(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public void setAllInfo(String username, String name, String password, String gender, String pet,
                           String maritalStatus, String relationshipType, int age, int income,
                           ArrayList<Double> location) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.pet = pet;
        this.maritalStatus = maritalStatus;
        this.relationshipType = relationshipType;
        this.age = age;
        this.income = income;
        this.location = location;
    }

    public ArrayList<Object> getInfo() {
        this.userInfo.add(username);
        this.userInfo.add(name);
        this.userInfo.add(password);
        return this.userInfo;
    }

    public ArrayList<Object> getAllInfo() {
        this.userInfo.add(username);
        this.userInfo.add(name);
        this.userInfo.add(password);
        this.userInfo.add(gender);
        this.userInfo.add(age);
        this.userInfo.add(income);
        this.userInfo.add(pet);
        this.userInfo.add(maritalStatus);
        this.userInfo.add(relationshipType);
        this.userInfo.add(location);
        return this.userInfo;
    }
}
