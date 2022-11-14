package use_case_signin_signup;

public class SigninPageResponseModel implements SigninPageOutputBoundary{
    private String errorMsg;
    @Override
    public void showErrorMessage(String err) {
        this.errorMsg = err;
    }
}
