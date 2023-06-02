package glassRulesTest;

import assemblyPages.GlassRules;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlassRulesTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void findGlassRules(){
        homePage.clickKits();
        homePage.clickGlassRules();
    }
    @Test(priority = 3, dependsOnMethods = {"validLoginTests","findGlassRules"})
    public void createNewItem(){
        GlassRules glassRules = new GlassRules(driver);
        glassRules.clickCreateButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        glassRules.clickPencilButton();
        glassRules.clickDropdown();
        glassRules.searchValue("[TEST] COLOR");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        glassRules.saveInput();
    }
    @Test(priority = 4, dependsOnMethods = {"validLoginTests","findGlassRules"} )
    public void searchItem(){
        GlassRules glassRules = new GlassRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glassRules.searchItem(" 0\" [TEST] COLOR");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(glassRules.getSearchText(), "0\" [TEST] COLOR", "Wrong message");
    }
    @Test(priority = 5, dependsOnMethods = {"validLoginTests","findGlassRules","searchItem"})
    public void deleteItem(){
        GlassRules glassRules = new GlassRules(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glassRules.selectToggle();
        glassRules.deleteItem();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(glassRules.findNoDataText(), "NO DATA AVAILABLE", "Wrong message");
    }
    @Test(priority = 6, dependsOnMethods = {"validLoginTests","findGlassRules"})
    public void testSorting(){
        GlassRules glassRules = new GlassRules(driver);
        glassRules.sortName();

    }

}
