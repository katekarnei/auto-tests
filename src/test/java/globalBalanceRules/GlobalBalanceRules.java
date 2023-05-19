package globalBalanceRules;

import assemblyPages.HomePage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalBalanceRules extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void testGlobalBalanceRules(){
        homePage.clickKits();
        homePage.clickBalanceRules();
        //check how long http query took
        long startTime = System.currentTimeMillis();
        driver.get("https://beta.eswindows.co/admin/v3/global_balance_rules/index");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Page loaded in " + duration + " milliseconds");
        homePage.setSortBalanceType();
        homePage.setSortAscType();//need to add some checks to verify sorting
        homePage.clickCreatedAt();
    }
    @Test (priority = 3, dependsOnMethods = {"validLoginTests", "testGlobalBalanceRules"})
    public void testSearchByBalanceType(){
        homePage.sendKeysSearchBar("SPIRAL");// BT or SPIRAL
        homePage.clickEnter();
        homePage.searchRes("SPIRAL");// BT or SPIRAL
    }

}
