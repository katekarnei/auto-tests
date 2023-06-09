package cutsTable;

import pages.kitComponentsPages.CutsPage;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CutsTableTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void findCuts(){
        homePage.clickKits();
        homePage.clickCutsTab();
    }
    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findCuts"})
    public void createNewCuts(){
        CutsPage cutsPage = new CutsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.setCutsName("[TEST] CUTS NAME");
        cutsPage.setLeftAngleValue("2");
        cutsPage.setRightAngleValue("3");
        cutsPage.setHeightValue("4");
    }
    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findCuts"})
    public void searchByName(){
        CutsPage cutsPage = new CutsPage(driver);
        cutsPage.searchCuts("[TEST] CUTS NAME");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(cutsPage.getCutsName(), "[TEST] CUTS NAME", "Wrong message");
    }
    @Test(priority = 4, dependsOnMethods = {"validLoginTests","findCuts"})
    public void testCutsSorting(){
        CutsPage cutsPage = new CutsPage(driver);
        cutsPage.testColumnsSorting();
    }
    @Test(priority = 5, dependsOnMethods = {"validLoginTests","findCuts"})
    public void editCutsName(){
        CutsPage cutsPage = new CutsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.setCutsName("[TEST] NAME TO BE EDITED");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.setCutsName("[TEST] NAME EDITED");
    }
    @Test(priority = 6,dependsOnMethods = {"validLoginTests","findCuts"})
    public void deleteItem(){
        CutsPage cutsPage = new CutsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.setCutsName("[TEST] NAME TO BE DELETED");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.searchCuts("[TEST] NAME TO BE DELETED");
        cutsPage.selectToggleButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        cutsPage.clickDeleteButton();
        Assert.assertEquals(cutsPage.getNoDataText(), "NO DATA AVAILABLE", "Wrong message");
    }

}
