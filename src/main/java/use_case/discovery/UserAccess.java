package use_case.discovery;

import entity.User;
import use_case.signin_signup.UserRequestModel;
import use_case.signin_signup.UserResponseModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface UserAccess {
    Map<String, UserRequestModel> readUser() throws IOException;
    UserResponseModel readCurrentUser();

}
