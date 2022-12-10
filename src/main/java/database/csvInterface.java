package database;

import use_case.signin_signup.UserRequestModel;
import use_case.signin_signup.UserResponseModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface csvInterface {

     Map<String, UserRequestModel> readUser() throws IOException;
     UserRequestModel readCurrentUser();

     void writeCurrentUser(String username, String name, String password, List<Double> location,
            Map<String, Object> userSetting, List<String> interestRank, String areaOfInterest);

     void writeUser(Map<String, UserResponseModel> userMap);

}
