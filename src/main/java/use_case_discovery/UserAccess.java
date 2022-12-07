package use_case_discovery;

import use_case_signin_signup.UserRequestModel;
import use_case_signin_signup.UserResponseModel;

import java.io.IOException;
import java.util.Map;

public interface UserAccess {
    Map<String, UserRequestModel> readUser() throws IOException;
    UserResponseModel readCurrentUser();

}