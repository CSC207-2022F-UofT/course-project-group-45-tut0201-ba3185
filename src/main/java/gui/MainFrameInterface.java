package gui;

public interface MainFrameInterface {
    public void switchToLogin();
    public void switchToSignup();

    public void switchToInitSetup(String username, String name, String password);

    public void switchToMain();
}