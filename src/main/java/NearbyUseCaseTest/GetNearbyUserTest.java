package NearbyUseCaseTest;

import entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecase.GetNearbyUserHelper;

import java.util.ArrayList;

public class GetNearbyUserTest {
    User user1;
    User user2;
    User user3;
    User currentuser;
    ArrayList<User> UserList = new ArrayList<>();

    @Before
    public void Setup(){
        currentuser = new User("zzy", "zzy", "123");
        user1 = new User("cam", "cam", "123");
        UserList.add(user1);
        user2 = new User("aly", "aly", "123");
        UserList.add(user2);
        user3 = new User("amb", "amb", "123");
        UserList.add(user3);

        //assume the current user is in BA
        //location of BA: lat:43.65985123321202, long:-79.39688861560464
        ArrayList<Double> currentLocation = new ArrayList<>();
        currentLocation.add(-79.39688861560464);
        currentLocation.add(43.65985123321202);
        currentuser.setLocation(currentLocation);
    }

    @Test //users have different distance
    public void case1(){

        //choose three random places
        //location of pearson airport: lat: 43.687077336119955, long: -79.62092811560365
        ArrayList<Double> location2 = new ArrayList<>();
        location2.add(-79.62092811560365);
        location2.add(43.687077336119955);
        user2.setLocation(location2);

        //location of Niagara SkyWheel: lat:43.09140474351913, long: -79.07566369402424
        ArrayList<Double> location1 = new ArrayList<>();
        location1.add(-79.07566369402424);
        location1.add(43.09140474351913);
        user1.setLocation(location1);

        //location of Times Square: lat: 43.8450887193633, long: -79.38388621744939
        ArrayList<Double> location3 = new ArrayList<>();
        location3.add(-79.38388621744939);
        location3.add(43.8450887193633);
        user3.setLocation(location3);

        ArrayList<String> res = new ArrayList<>();
        res.add(user2.getUsername());
        res.add(user1.getUsername());
        res.add(user3.getUsername());

        GetNearbyUserHelper helper = new GetNearbyUserHelper(currentuser, UserList);

        Assert.assertEquals(res, helper.getNearbyUser());
    }

    @Test //two users have the same location
    public void case2(){
        //location of pearson airport: lat: 43.687077336119955, long: -79.62092811560365
        ArrayList<Double> location2 = new ArrayList<>();
        location2.add(-79.62092811560365);
        location2.add(43.687077336119955);
        user2.setLocation(location2);

        //location of Niagara SkyWheel: lat:43.09140474351913, long: -79.07566369402424
        ArrayList<Double> location1 = new ArrayList<>();
        location1.add(-79.07566369402424);
        location1.add(43.09140474351913);
        user1.setLocation(location1);

        //user3 has the same location as user2
        ArrayList<Double> location3 = new ArrayList<>();
        location3.add(-79.62092811560365);
        location3.add(43.687077336119955);
        user3.setLocation(location3);

        ArrayList<String> res = new ArrayList<>();
        res.add(user2.getUsername());
        res.add(user3.getUsername());
        res.add(user1.getUsername());

        GetNearbyUserHelper helper = new GetNearbyUserHelper(currentuser, UserList);

        Assert.assertEquals(res, helper.getNearbyUser());
    }
}

