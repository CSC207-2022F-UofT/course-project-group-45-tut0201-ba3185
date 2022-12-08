package use_case_frontpage;

public class FrontPageRequestModel {
    /**
     * The request model generated by the controller to be passed to the interactor
     * to be processed.
     * Contain the target who the current user is chatting with.
     */
    private final String target;

    public FrontPageRequestModel(){
        this.target = null;
    }

    public FrontPageRequestModel(String target){
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
