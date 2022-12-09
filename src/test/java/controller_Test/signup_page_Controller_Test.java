
package controller_Test;

import controller.SignupPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class signup_page_Controller_Test {

    static SignupPageController controller;

    @BeforeAll
    public static void setup(){
        controller = new SignupPageController();
    }

    @Test
    public void testUserExists() throws IOException {
        Assertions.assertTrue(controller.userExist("sunny"));
        Assertions.assertFalse(controller.userExist("hahahahah"));
    }
}
