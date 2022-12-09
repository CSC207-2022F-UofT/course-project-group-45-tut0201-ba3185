package controller_Test;

import controller.SigninPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class signin_page_Controller_Test {

    static SigninPageController controller;

    @BeforeAll
    public static void setup(){
        controller = new SigninPageController();
    }

    @Test
    public void testMatchingPassword() throws IOException {
        Assertions.assertTrue(controller.matchingPassword("sunny", "sunny"));
        Assertions.assertFalse(controller.matchingPassword("sunny", "eric"));
    }

}
