package use_case_signin_signup;

public class SignupPageResponseModel implements SignupPageOutputBoundary{
    private String errorMessage;
    @Override
    public void showError(String err) {
        this.errorMessage = err;
    }
}
