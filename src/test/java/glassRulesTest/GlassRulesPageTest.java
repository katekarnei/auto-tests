package glassRulesTest;

import pages.kitComponentsPages.GlassRulesPage;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlassRulesPageTest extends BaseTest {

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
        GlassRulesPage glassRulesPage = new GlassRulesPage(driver);
        glassRulesPage.clickCreateButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        glassRulesPage.clickPencilButton();
        glassRulesPage.clickDropdown();
        glassRulesPage.searchDropdownValue("[TEST] COLOR");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        glassRulesPage.saveInput();
    }
    @Test(priority = 4, dependsOnMethods = {"validLoginTests","findGlassRules"} )
    public void searchItem(){
        GlassRulesPage glassRulesPage = new GlassRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glassRulesPage.searchItem(" 0\" [TEST] COLOR");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(glassRulesPage.getSearchText(), "0\" [TEST] COLOR", "Wrong message");
    }
    @Test(priority = 5, dependsOnMethods = {"validLoginTests","findGlassRules","searchItem"})
    public void deleteItem(){
        GlassRulesPage glassRulesPage = new GlassRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glassRulesPage.selectToggleButton();
        glassRulesPage.clickDeleteButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        Assert.assertEquals(glassRulesPage.getNoDataText(), "NO DATA AVAILABLE", "Wrong message");
    }
    @Test(priority = 6, dependsOnMethods = {"validLoginTests","findGlassRules"})
    public void testSorting(){
        GlassRulesPage glassRulesPage = new GlassRulesPage(driver);
        glassRulesPage.sortByName();

    }

}
