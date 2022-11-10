package use_case_signin_signup;
import entity.User;

public class SigninPageManager implements SigninPageInputBoundary{

    private SigninPageOutputBoundary presenter;

    public SigninPageManager(SigninPageOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getFieldInfo(SigninPageRequestModel reqmodel) {

    }

    @Override
    public void userCheck(SigninPageRequestModel reqmodel) {

    }

    @Override
    public void userFactory(SigninPageRequestModel reqmodel) {

    }
}
