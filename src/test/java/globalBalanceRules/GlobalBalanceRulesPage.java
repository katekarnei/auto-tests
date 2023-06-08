package globalBalanceRules;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.kitComponentsPages.BalanceRulesPage;

import java.time.Duration;

public class GlobalBalanceRulesPage extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void findBalanceRulesTab(){
        homePage.clickKits();
        homePage.clickBalanceRules();
        //check how long http query took
        long startTime = System.currentTimeMillis();
        driver.get("https://beta.eswindows.co/admin/v3/global_balance_rules/index");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Page loaded in " + duration + " milliseconds");
    }

    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findBalanceRulesTab"})
    public void testBalanceRulesSorting(){
        BalanceRulesPage balanceRulesPage = new BalanceRulesPage(driver);
        balanceRulesPage.sortByName();


    }
    @Test (priority = 4, dependsOnMethods = {"validLoginTests","findBalanceRulesTab"})
    public void testSearchByBalanceType(){
        BalanceRulesPage balanceRulesPage = new BalanceRulesPage(driver);
        balanceRulesPage.sendKeysSearchBar("SPIRAL");// BT or SPIRAL
        balanceRulesPage.searchRes("SPIRAL");// BT or SPIRAL
    }

}
