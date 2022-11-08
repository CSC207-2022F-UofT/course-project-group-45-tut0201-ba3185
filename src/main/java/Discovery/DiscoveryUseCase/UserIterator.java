package Discovery.DiscoveryUseCase;
import User.User;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Want a new class called 'UserFactory',
 * it takes the responsibility of load the data of all the user info,
 * the user info are automatically added to the file
 * that will be saved and exported after every new user is created/deleted
 * To load the data, it's to create instances of user automatically, so that they become iterable
 * (User of factory pattern)
 * To make the class User become iterable, for iterator design pattern
 */

/*
class UserRecord implements Iterable<User> {
    UserFactory newUserFactory = UserFactory;

    @Override
    public Iterator<User> iterator() {
        return new UserIterator(newUserFactory.getUsers());
    }
*/


public class UserIterator implements Iterator<User> {
    //The index of the next Contact to return.
    private int currentPosition = 0;
    private final ArrayList<User> otherUserList;


    public UserIterator(ArrayList<User> otherUserList) {
        this.otherUserList = otherUserList;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < this.otherUserList.size();
    }

    @Override
    public User next() {
        if (!hasNext()) {
            return null;
        }
        User returnUser = this.otherUserList.get(currentPosition);
        currentPosition++;
        return returnUser;
    }

}
/*}*/
