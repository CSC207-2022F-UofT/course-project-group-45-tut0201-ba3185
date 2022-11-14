package use_case_signin_signup;

import entity.User;
import entity.Users;
import java.util.ArrayList;

public class SignupPageManager implements SignupPageInputBoundary {

    private SignupPageOutputBoundary presenter;
    private String username;
    private String name;
    private String password;
    private ArrayList<Double> location;
    private final Users users;

    public SignupPageManager(SignupPageOutputBoundary presenter) {
        this.presenter = presenter;
        this.users = new Users();
    }

    @Override
    public void getFieldInfo(SignupPageRequestModel reqmodel) {
        this.username = reqmodel.getUsername();
        this.name = reqmodel.getName();
        this.password = reqmodel.getPassword();
        this.location = reqmodel.getLocation();
    }

    @Override
    public Boolean userCheck() {
        // if the username is in some database or smt
        return !users.getUsernameList().contains(username);
    }

    @Override
    public void userFactory() {
        // we can do something to this user to store it.
        if(this.userCheck()) {
            User user = new User(name, username,password, location);
            this.users.addUser(username, user);
        }
    }

    @Override
    public void setError() {
        if(users.getUsernameList().contains(username)) {
            presenter.showError("Username is already taken");
        };
    }
}
