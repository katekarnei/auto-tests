package incorrectLogin;

import assemblyPages.HomePage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class IncorrectLogin extends BaseTest {
    @Test(priority = 1)
    public void incorrectEmail(){
        logInPage.setLogin("username@email.com");
        logInPage.setPassword(passCode);
        logInPage.clickLoginButton();
        Assert.assertEquals(logInPage.getErrorAlert(), "INVALID EMAIL OR PASSWORD.",
                "Wrong message"
                );
    }
        @Test(priority = 2)
        public void incorrectPassword(){
            logInPage.setLogin(userName);
            logInPage.setPassword("wrongpassword");
            logInPage.clickLoginButton();
            Assert.assertEquals(logInPage.getErrorAlert(), "INVALID EMAIL OR PASSWORD.",
                    "Wrong message"
            );}
    }

