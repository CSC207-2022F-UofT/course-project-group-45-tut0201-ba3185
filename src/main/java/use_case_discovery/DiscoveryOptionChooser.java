package use_case_discovery;

import java.util.ArrayList;

public class DiscoveryOptionChooser implements DiscoveryOptionInputBoundary {

    private DiscoveryOptionOutputBoundary presenter;

    public DiscoveryOptionChooser(DiscoveryOptionOutputBoundary presenter){
        this.presenter = presenter;
    }

    public void generateTypeOption(){
        ArrayList<String> type_option = new ArrayList<>();
        type_option.add("By preference");
        type_option.add("By Location");
        type_option.add("By Search");

        presenter.showOption(type_option);

    }

}
