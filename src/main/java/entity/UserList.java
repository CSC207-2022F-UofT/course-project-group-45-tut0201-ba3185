package entity;

import java.util.ArrayList;
import java.util.Iterator;

public class UserList implements Iterable<User> {
    private int size;
    private ArrayList<User> lst;
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
