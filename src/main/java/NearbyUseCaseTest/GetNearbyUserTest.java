package NearbyUseCaseTest;

import entity.User;
import entity.UserList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecase.GetNearbyUserHelper;

import java.util.ArrayList;

public class GetNearbyUserTest {
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;
    User currentuser;
    ArrayList<User> UserList1 = new ArrayList<>();
    ArrayList<User> UserList2 = new ArrayList<>();

    @Before
    public void Setup(){
        currentuser = new User("zzy", "zzy", "123");
        //assume the current user is in BA
        //location of BA: lat:43.65985123321202, long:-79.39688861560464
        ArrayList<Double> currentLocation = new ArrayList<>();
        currentLocation.add(-79.39688861560464);
        currentLocation.add(43.65985123321202);
        currentuser.setLocation(currentLocation);
    }

    @Test //users have different distance
    public void case1(){

        user1 = new User("cam", "cam", "123");
        UserList1.add(user1);
        user2 = new User("aly", "aly", "123");
        UserList1.add(user2);
        user3 = new User("amb", "amb", "123");
        UserList1.add(user3);
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

        //location of Tiananmen Square: lat: 39.90569523235851, long:116.39763169790143
        ArrayList<Double> location3 = new ArrayList<>();
        location3.add(116.39763169790143);
        location3.add(39.90569523235851);
        user3.setLocation(location3);

        ArrayList<String> res = new ArrayList<>();
        res.add(user2.getUsername());
        res.add(user1.getUsername());
        res.add(user3.getUsername());

        GetNearbyUserHelper helper = new GetNearbyUserHelper(currentuser, UserList1);

        Assert.assertEquals(res, helper.getNearbyUser());
    }

    @Test //two users have the same location
    public void case2(){
        user4 = new User("chr", "chr", "123");
        UserList2.add(user4);
        user5 = new User("jen", "jen", "123");
        UserList2.add(user5);
        user6 = new User("eri", "eri", "123");
        UserList2.add(user6);
        //location of pearson airport: lat: 43.687077336119955, long: -79.62092811560365
        ArrayList<Double> location5 = new ArrayList<>();
        location5.add(-79.62092811560365);
        location5.add(43.687077336119955);
        user5.setLocation(location5);

        //location of Niagara SkyWheel: lat:43.09140474351913, long: -79.07566369402424
        ArrayList<Double> location4 = new ArrayList<>();
        location4.add(-79.07566369402424);
        location4.add(43.09140474351913);
        user4.setLocation(location4);

        //user3 has the same location as user2
        ArrayList<Double> location6 = new ArrayList<>();
        location6.add(-79.62092811560365);
        location6.add(43.687077336119955);
        user6.setLocation(location6);

        ArrayList<String> res = new ArrayList<>();
        res.add(user5.getUsername());
        res.add(user6.getUsername());
        res.add(user4.getUsername());

        GetNearbyUserHelper helper = new GetNearbyUserHelper(currentuser, UserList2);

        Assert.assertEquals(res, helper.getNearbyUser());
    }
}

