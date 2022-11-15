package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class UserListIterator<U> implements Iterator<User> {

    private int pointer;
    private UserList lst;

    public UserListIterator(UserList lst) {
        this.lst = lst;
    }

    @Override
    public boolean hasNext() {
        return pointer+1 == lst.size();
    }

    @Override
    public User next() {
        return lst.get(pointer+1);
    }
}
