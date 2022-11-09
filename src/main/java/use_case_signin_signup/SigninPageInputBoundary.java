package use_case_signin_signup;
import entity.User;

public interface SigninPageInputBoundary {
    public void getFieldInfo(SigninPageRequestModel reqmodel);
    public void userCheck(SigninPageRequestModel reqmodel);
    public void userFactory(SigninPageRequestModel reqmodel);
}
