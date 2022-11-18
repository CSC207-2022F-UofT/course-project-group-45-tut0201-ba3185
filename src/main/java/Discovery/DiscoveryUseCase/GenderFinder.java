package Discovery.DiscoveryUseCase;
import User.Users;
import User.User;

import java.util.ArrayList;

/**
 * GenderFinder takes user's sexual orientation and filter other users based
 * Documentary of possible sexual orientation:
 *(possible sexual orientation): (return from GenderFinder)
 * male: return only users identified themselves as male
 * female: return only users identified themselves as female
 * bisexual: return only users identified themselves as both male and female
 * transgender: return only users identified themselves as transgender
 * open: return all the users
 */

//to use the class, create an instance of GenderFinder and then call the method getList
public class GenderFinder {
    ArrayList<User> genderSuitFinder;//list to store the user after GenderFinder

    User mainUser = Users.getCurrentUser(); //to get the main user's sexualOrientation
    String mainUserChoice = (String)mainUser.getUserInfo("sexualOrientation");
    //UserFactory tempUserFactory = new UserFactory(); //to get a List of other users
    UsersList userLst;//the type of user list that allows to loop over

    public GenderFinder(){
        ArrayList<User> res = new ArrayList<>();
        //male,female, transgender cases
        if (mainUserChoice.equals("male")||
                mainUserChoice.equals("female")||
                mainUserChoice.equals("transgender")){
            for (User otherUsers:userLst){
                //user.sexualOrientation is variable recording user's sexualOrientation
                if (otherUsers.getUserInfo("gender").equals(mainUserChoice)){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return;
        }
        //the bisexual cases
        if (mainUserChoice.equals("bisexual")){
            for (User otherUsers:userLst){
                if (otherUsers.getUserInfo("gender").equals("male")||
                        otherUsers.getUserInfo("gender").equals("female")){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return;
        }
        //open case
            for (User otherUsers:userLst){
                res.add(otherUsers);}

            this.genderSuitFinder = res;
        }
    public ArrayList<User> getList(){return this.genderSuitFinder;}

    }



