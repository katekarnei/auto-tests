package globalDisplayRules;

import pages.kitComponentsPages.DisplayRulesPage;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlobalDisplayRulesPage extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void findDisplayRules(){
        homePage.clickKits();
        homePage.clickDisplayRules();
    }
    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void createNewItem(){
        DisplayRulesPage displayRulesPage = new DisplayRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.setItemName("[TEST] ITEM 1");
        displayRulesPage.clickQTypePencil();
        displayRulesPage.clickSelectDropdown("frame width");
        displayRulesPage.clickMinPencilButton();
        displayRulesPage.setMinValue("2");
        displayRulesPage.clickMaxPencilButton();
        displayRulesPage.setMaxValue("5");

    }
    @Test(priority=4, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void sortingTable(){
        DisplayRulesPage displayRulesPage = new DisplayRulesPage(driver);
        displayRulesPage.sortByName();
    }

    @Test(priority = 5, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void searchValueTest(){
        DisplayRulesPage displayRulesPage = new DisplayRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        displayRulesPage.searchingTest("[TEST] ITEM 1");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(displayRulesPage.getItemName(), "[TEST] ITEM 1", "Wrong message");
    }

    @Test(priority = 6,dependsOnMethods = {"validLoginTests","findDisplayRules",})
    public void editName(){
        DisplayRulesPage displayRulesPage = new DisplayRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.setItemName("[TEST] EDITED 4");
        displayRulesPage.clickQTypePencil();
        displayRulesPage.clickSelectDropdown("glass width");
        displayRulesPage.clickMinPencilButton();
        displayRulesPage.setMinValue("12");
        displayRulesPage.clickMaxPencilButton();
        displayRulesPage.setMaxValue("33");

    }
    @Test(priority = 7, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void deleteSingleItem(){
        DisplayRulesPage displayRulesPage = new DisplayRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.setItemName("[TEST] DELETION ITEM 1");
        displayRulesPage.searchingTest("[TEST] DELETION ITEM 1");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.selectToggleButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRulesPage.clickDeleteButton();
        Assert.assertEquals(displayRulesPage.getNoDataText(), "NO DATA AVAILABLE", "Wrong Message");
    }






}
