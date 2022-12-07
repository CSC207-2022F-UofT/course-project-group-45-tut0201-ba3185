package entity;
import use_case_signin_signup.UserRequestModel;

public class UserFactory {

    /**
     * The UserFactory enttiy is to create new users from information from the requestModel
     */

    /**
     * The create method for UserFactory, creates a new user with information from the requestModel
     * @param requestModel: UserRequestmodel containing all the information needed to make a new user
     * @return A new User object created from the information in the requestModel
     */
    public User create(UserRequestModel requestModel) {
        return new User(requestModel.getUsername(), requestModel.getName(), requestModel.getPassword(),
                requestModel.getLocation(), requestModel.getUserSetting(), requestModel.getInterestRank(),
                requestModel.getAreaOfInterest());
    }
}
