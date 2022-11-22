import User.UserForTest;
import User.Users;
import org.junit.Before;
import org.junit.Test;

public class GenderFinderTest {
    Users users;
    UserForTest mainUser;
    UserForTest user1;
    UserForTest user2;
    UserForTest user3;
    UserForTest user4;
    UserForTest user5;
    UserForTest user6;
    UserForTest user7;

    @Before
    public void setUp() {
        this.mainUser = new UserForTest("alyssa", "alyssa", "111", "Female", "Female");
        this.user1 = new UserForTest("cami", "cami", "111", "Female", "Male");
        this.user2 = new UserForTest("chris", "chris", "222", "Female", "Male");
        this.user3 = new UserForTest("amber", "amber", "333", "Female", "Male");
        this.user4 = new UserForTest("sunny", "sunny", "333", "Male", "Female");
        this.user5 = new UserForTest("eric", "eric", "333", "Male", "Female");
        this.user6 = new UserForTest("jeniffer", "jeniffer", "333", "Female", "Male");


        users = new Users();
        users.setCurrentUser(mainUser);
        users.addUser("cami", user1);
        users.addUser("chris", user2);
        users.addUser("amber", user3);
        users.addUser("sunny", user4);
        users.addUser("eric", user5);
        users.addUser("jeniffer", user6);
        users.addUser("trans", user7);
    }
    @Test
    public void MaleCase() {

    }
}
