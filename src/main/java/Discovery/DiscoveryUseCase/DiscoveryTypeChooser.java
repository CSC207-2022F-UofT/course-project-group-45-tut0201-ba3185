package Discovery.DiscoveryUseCase;

import java.util.ArrayList;

public class DiscoveryTypeChooser {

    public DiscoveryTypeChooser(){}

    public ArrayList<String> SetTypeOption(){
        ArrayList<String> type_option = new ArrayList<>();
        type_option.add("1. By preference");
        type_option.add("2. By Location");
        type_option.add("3. Search");

        return type_option;
    }


}
