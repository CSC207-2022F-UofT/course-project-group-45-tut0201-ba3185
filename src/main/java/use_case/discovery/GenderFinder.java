package use_case.discovery;
import User.UserForTest;

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
    // TODO: need to fetch with User
    //csvManager manager = new csvManager();
    //manager.read
    TestUser testUser = new TestUser();
    ArrayList<UserForTest> genderSuitFinder;//list to store the user after GenderFinder
    UserForTest mainUser = testUser.getMainUser(); //to get the main user's sexualOrientation
    String mainSexualOrientation = mainUser.getSexualOrientation();
    ArrayList<UserForTest> otherUsersList= testUser.getOtherUsers();

    public GenderFinder(){
        ArrayList<UserForTest> res = new ArrayList<>();
        if (mainSexualOrientation.equals("Male")||
                mainSexualOrientation.equals("Female")||
                mainSexualOrientation.equals("Transgender")){
            for (UserForTest otherUsers:otherUsersList){
                //user.sexualOrientation is variable recording user's sexualOrientation
                if (otherUsers.getGender().equals(mainSexualOrientation)){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return;
        }
        //the bisexual cases
        if (mainSexualOrientation.equals("Bisexual")){
            for (UserForTest otherUsers:otherUsersList){
                if (otherUsers.getGender().equals("Male")||
                        otherUsers.getGender().equals("Female")){res.add(otherUsers);}
            }
            this.genderSuitFinder = res;
            return;
        }
        //open case
        res.addAll(otherUsersList);
            this.genderSuitFinder = res;
        }
    public ArrayList<UserForTest> getList(){return this.genderSuitFinder;}
}



