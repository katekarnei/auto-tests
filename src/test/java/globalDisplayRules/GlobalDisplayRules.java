package globalDisplayRules;

import assemblyPages.DisplayRules;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlobalDisplayRules extends BaseTest {

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
        DisplayRules displayRules = new DisplayRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.setItemName("[TEST] ITEM 1");
        displayRules.clickQTypePencil();
        displayRules.clickSelectDropdown("frame width");
        displayRules.clickMinPencilButton();
        displayRules.setMinValue("2");
        displayRules.clickMaxPencilButton();
        displayRules.setMaxValue("5");

    }
    @Test(priority = 4, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void searchValueTest(){
        DisplayRules displayRules = new DisplayRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        displayRules.searchingTest("[TEST] ITEM 1");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(displayRules.getItemName(), "[TEST] ITEM 1", "Wrong message");
    }
    @Test(priority=5, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void sortingTable(){
        DisplayRules displayRules = new DisplayRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.setItemName("[TEST] SORTING ITEM 1");
        displayRules.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.setItemName("[TEST] SORTING ITEM 2");
        displayRules.searchingTest("[TEST] SORTING ITEM");
        displayRules.getValueNameSorting();
    }

    @Test(priority = 6,dependsOnMethods = {"validLoginTests","findDisplayRules",})
    public void editName(){
        DisplayRules displayRules = new DisplayRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.setItemName("[TEST] EDITED 4");
        displayRules.clickQTypePencil();
        displayRules.clickSelectDropdown("glass width");
        displayRules.clickMinPencilButton();
        displayRules.setMinValue("12");
        displayRules.clickMaxPencilButton();
        displayRules.setMaxValue("33");

    }
    @Test(priority = 7, dependsOnMethods = {"validLoginTests","findDisplayRules"})
    public void deleteSingleItem(){
        DisplayRules displayRules = new DisplayRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.setItemName("[TEST] DELETION ITEM 1");
        displayRules.searchingTest("[TEST] DELETION ITEM 1");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.selectToggle();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        displayRules.deleteItem();
        Assert.assertEquals(displayRules.getNoDataText(), "NO DATA AVAILABLE", "Wrong Message");
    }






}
