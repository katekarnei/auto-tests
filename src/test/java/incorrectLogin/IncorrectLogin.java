package incorrectLogin;

import assemblyPages.HomePage;
import baseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class IncorrectLogin extends BaseTest {
    @Test
    public void loginTests(){
        // see generated test examples in a test case
        logInPage.setLogin("username@email.com");
        logInPage.setPassword("password");
        logInPage.clickLoginButton();
        assertEquals(logInPage.getErrorAlert(), "INVALID EMAIL OR PASSWORD.",
                "Wrong message"
                );


    }
}
