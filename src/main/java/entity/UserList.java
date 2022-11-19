package entity;

import java.util.ArrayList;
import java.util.Iterator;

/*
    UserList Entity is an entity to allow iterable to be implemented to a list of Users,
 */
public class UserList implements Iterable<User> {
    /*
     @params:
        lst: an ArrayList of users

     @methods:
        iterator(): returns a new UserListIterator, this allows iterator function in iterable.
     */
    private ArrayList<User> lst;

    public UserList() {
        this.lst = new ArrayList<User>();
    }
    @Override
    public Iterator<User> iterator() {
        return new UserListIterator<User>(this);
    }

    public void add(User user) {
        lst.add(user);
    }

    public int size() {
        return lst.size();
    }
    public User get(int idx) {
        return lst.get(idx);
    }
}