package loginTest;

import assemblyPages.HomePage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTest extends BaseTest {

    @Test
    public void loginTests(){
        logInPage.setLogin("username@email.com");
        logInPage.setPassword("password");
        HomePage homePage = logInPage.clickLoginButton();
        Assert.assertNotNull(homePage.getSignedinTest(), "SIGNED IN SUCCESSFULLY");


    }
}
