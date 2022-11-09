package presenter;

import User.User;
import use_case_discovery.DiscoveryListOutputBoundary;

import java.util.ArrayList;



public class ListPresenter implements DiscoveryListOutputBoundary {

    final int displayAmount = 15;


    public ArrayList<User> displayList(int n, ArrayList<User> recommendList) {
        ArrayList<User> listAfterCut = new ArrayList<>();

        for(int i = 0 + n * 15; i < displayAmount + n * 15; i ++){
            listAfterCut.add(recommendList.get(0));
        }

        return  listAfterCut;
    }
}
