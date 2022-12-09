package gui;

public interface MainFrameInterface {
    void switchToLogin();
    void switchToSignup();
    void switchToInitSetup(String username, String name, String password);
    void switchToMain();
}