package Discovery;

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
    String userChoice = User.getSexualOrientation();
    public ArrayList<User> getList(ArrayList<User> otherUser){
        ArrayList<User> res = new ArrayList<User>();
        //male,female, transgender cases
        if (userChoice.equals("male")||
                userChoice.equals("female")||
                userChoice.equals("transgender")){
            for (User otherUser:otherUser){
                //user.sexualOrientation is variable recording user's sexualOrientation
                if (otherUser.getSexualOrientation().equals(userChoice)){res.add(otherUser);}
            }
            return res;
        }
        //the bisexual cases
        if (userChoice.equals("bisexual")){
            for (User otherUser:otherUser){
                if (otherUser.getSexualOrientation().equals("male")||
                        otherUser.getSexualOrientation().equals("female")){res.add(otherUser);}
            }
            return res;
        }
        //open case
        return otherUser;
    }
}
