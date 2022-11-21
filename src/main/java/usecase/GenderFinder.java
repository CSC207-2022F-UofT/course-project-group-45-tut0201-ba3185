package usecase;
import entity.UserList;
import entity.Users;
import entity.User;

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
    ArrayList<User> genderSuitFinder;//list to store the users after GenderFinder
    Users users;
    User currentUser;  //to get the main user's sexualOrientation
    String currentUserChoice; //= (String)currentUser.getUserInfo("relationshipType");
    //UserFactory tempUserFactory = new UserFactory(); //to get a List of other users
    UserList userLst;//the type of user list that allows to loop over

    public GenderFinder(){
        users = new Users();
        currentUser = users.getCurrentUser();
        currentUserChoice = (String)currentUser.getUserInfo("relationshipType");
        ArrayList<User> res = new ArrayList<>();
        //male,female, transgender cases
        if (currentUserChoice.equals("male")||
                currentUserChoice.equals("female")||
                currentUserChoice.equals("transgender")){
            for (User otherUser:userLst){
                //user.relationshipType is variable recording user's preferred relationshipType
                if (otherUser.getUserInfo("gender").equals(currentUserChoice)){
                    res.add(otherUser);
                }
            }
            this.genderSuitFinder = res;
            return;
        }
        //the bisexual cases
        else if (currentUserChoice.equals("bisexual")){
            for (User otherUsers:userLst){
                if (otherUsers.getUserInfo("gender").equals("male")||
                        otherUsers.getUserInfo("gender").equals("female")){
                    res.add(otherUsers);
                }
            }
            this.genderSuitFinder = res;
            return;
        }
        //open case
        else{
        for (User otherUsers:userLst){
            res.add(otherUsers);}
        }

        this.genderSuitFinder = res;
    }
    public ArrayList<User> getList(){return this.genderSuitFinder;}

}



