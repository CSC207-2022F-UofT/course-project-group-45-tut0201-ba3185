package use_case_discovery;

import User.User;

import java.util.ArrayList;

public interface DiscoveryListOutputBoundary {
    public ArrayList<User> displayList(int n, ArrayList<User> recommendList);
}
