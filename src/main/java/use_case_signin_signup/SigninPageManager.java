package use_case_signin_signup;
import entity.Users;

import java.util.ArrayList;

public class SigninPageManager implements SigninPageInputBoundary{

    private SigninPageOutputBoundary presenter;
    private String username;
    private String password;
    private Users users;

    public SigninPageManager(SigninPageOutputBoundary presenter, Users users) {
        this.presenter = presenter;
        this.users = users;
        this.username = "";
        this.password = "";
    }

    @Override
    public void getFieldInfo(SigninPageRequestModel reqmodel) {
        this.username = reqmodel.getUsername();
        this.password = reqmodel.getPassword();
    }

    @Override
    public boolean userCheck() {
        // when the button is pressed, this will be triggered, if passes then there is a user and the user
        // is passed onto the use case or controller of the next section. if now smt else happen
        return !users.getUsernameList().contains(username);
    }

    @Override
    public void setError() {
        if(!userCheck()) {
            presenter.showErrorMessage("No user found with that username");
        }
        if(users.getUser(username).getPassword().equals(password)) {
            presenter.showErrorMessage("You have inputted the wrong password");
        }
    }
}