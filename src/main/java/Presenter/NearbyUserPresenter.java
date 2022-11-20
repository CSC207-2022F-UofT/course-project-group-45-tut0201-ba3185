package Presenter;

import usecase.LocationFinderOutputBoundary;

import java.util.ArrayList;

public class NearbyUserPresenter implements LocationFinderOutputBoundary {
    static final int displayAmount = 15;


    public ArrayList<String> displayList(ArrayList<String> recommendList) {
        ArrayList<String> listAfterCut = new ArrayList<>();

        for(int i = 0 ; i < displayAmount; i ++){
            listAfterCut.add(recommendList.get(i));
        }
        return listAfterCut;
    }
}