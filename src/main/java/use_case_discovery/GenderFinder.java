package use_case_discovery;

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

        public ArrayList<User> genderSuitFinder;

        public GenderFinder(){
            User user = new User("user2","name2","password");
            genderSuitFinder.add(user);
        }


    }
