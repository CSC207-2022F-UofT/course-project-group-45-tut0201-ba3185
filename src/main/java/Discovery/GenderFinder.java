package Discovery;

import User.UserFactory;

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

public class GenderFinder {
    /**
     * the variable of the class that stores the list after genderFinder
     */
    ArrayList<User.User> genderSuitFinder;
    String userChoice = User.User.getSexualOrientation(); //to get the main user's sexualOrientation
    UserFactory tempUserFactory = new UserFactory(); //to get a List of other users
    ArrayList<User.User> otherUsersList = tempUserFactory.getUsers();

    public GenderFinder(){
        this.genderSuitFinder = new ArrayList<>();
    }

    public boolean genderSuitFinderSetter(){
        ArrayList<User.User> res = new ArrayList<>();
        //male,female, transgender cases
        if (userChoice.equals("male")||
                userChoice.equals("female")||
                userChoice.equals("transgender")){
            for (User.User otherUsers:otherUsersList){
                //user.sexualOrientation is variable recording user's sexualOrientation
                if (otherUsers.getSexualOrientation().equals(userChoice)){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return true;
        }
        //the bisexual cases
        if (userChoice.equals("bisexual")){
            for (User.User otherUsers:otherUsersList){
                if (otherUsers.getSexualOrientation().equals("male")||
                        otherUsers.getSexualOrientation().equals("female")){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return true;
        }
        //open case
        genderSuitFinder = otherUsersList;
        return true;
    }

}
