import entity.User;
import entity.UserList;

public class Main {
    public static void main(String[] args) {
        UserList lst = new UserList();
        lst.add(new User("asd", "aso","asd"));
        lst.add(new User("aa", "o","asd"));
        lst.add(new User("beij", "beok","asd"));

        for(User user : lst) {
            System.out.println(user.getUsername());
        }
    }
}
