package use_case_discovery;

import presenter.OptionPresenter;

import java.util.ArrayList;

public class DiscoveryOptionChooser implements DiscoveryOptionInputBoundary {

    private DiscoveryOptionOutputBoundary presenter;

    public DiscoveryOptionChooser(DiscoveryOptionOutputBoundary presenter){
        this.presenter = presenter;
    }

    public void generateTypeOption(){
        ArrayList<String> type_option = new ArrayList<>();
        type_option.add("1. By preference");
        type_option.add("2. By Location");
        type_option.add("3. Search");

        presenter.showOption(type_option);

    }

}
