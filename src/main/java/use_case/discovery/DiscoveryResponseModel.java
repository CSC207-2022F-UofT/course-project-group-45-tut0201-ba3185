package use_case.discovery;
import java.util.List;
/*
The response model stores the information of the (15) users that is used to display
 */
public class DiscoveryResponseModel {
    private final List<String> userNames;
    /**
     *
     * @param userNames is a list of usernames that the discovered list of users to display
     */
    public DiscoveryResponseModel(List<String> userNames){
        this.userNames = userNames;
    }

    public String getUserName1(){return this.userNames.get(0);}
    public String getUserName2(){return this.userNames.get(1);}
    public String getUserName3(){return this.userNames.get(2);}
    public String getUserName4(){return this.userNames.get(3);}
    public String getUserName5(){return this.userNames.get(4);}
    public String getUserName6(){return this.userNames.get(5);}
    public String getUserName7(){return this.userNames.get(6);}
    public String getUserName8(){return this.userNames.get(7);}
    public String getUserName9(){return this.userNames.get(8);}
    public String getUserName10(){return this.userNames.get(9);}
    public String getUserName11(){return this.userNames.get(10);}
    public String getUserName12(){return this.userNames.get(11);}
    public String getUserName13(){return this.userNames.get(12);}
    public String getUserName14(){return this.userNames.get(13);}
    public String getUserName15(){return this.userNames.get(14);}
}

