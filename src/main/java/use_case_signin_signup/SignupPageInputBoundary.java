package use_case_signin_signup;

public interface SignupPageInputBoundary {
    public void getFieldInfo(SignupPageRequestModel reqmodel);
    public Boolean userCheck();
    public void userFactory();
    public void setError();
}
