package aluminumFinishRulesTest;

import assemblyPages.AlumFinishRulesPage;
import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AluminumFinishRulesTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTests(){
        logInPage.setLogin(userName);
        logInPage.setPassword(passCode);
        homePage = logInPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "validLoginTests")
    public void findAluminumFinishRules(){
        homePage.clickKits();
        homePage.clickAluminumFinish();
    }
    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findAluminumFinishRules"})
    public void createNewAluminumItem(){
        AlumFinishRulesPage alumFinishRulesPage = new AlumFinishRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.clickCreateButton();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.clickNamePencilButton();
        alumFinishRulesPage.setRuleName("[TEST] FINISH 1");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.saveNameItem();
    }

    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findAluminumFinishRules"})
    public void editCreatedItem(){
        AlumFinishRulesPage alumFinishRulesPage = new AlumFinishRulesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.clickNamePencilButton();
        alumFinishRulesPage.setRuleName("[TEST] FINISH EDITED");
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.saveNameItem();
    }
    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findAluminumFinishRules"})
    public void searchAluminumItem(){
        AlumFinishRulesPage alumFinishRulesPage = new AlumFinishRulesPage(driver);
        alumFinishRulesPage.searchByName("[TEST] FINISH");
        Assert.assertEquals(alumFinishRulesPage.getSearchResults(),"[TEST] FINISH","Wrong message");
    }
    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findAluminumFinishRules"})
    public void sortAluminumItem(){
        AlumFinishRulesPage alumFinishRulesPage = new AlumFinishRulesPage(driver);
        alumFinishRulesPage.searchByName("[TEST] FINISH");
        alumFinishRulesPage.sortByName();
    }
    @Test(priority = 2, dependsOnMethods = {"validLoginTests","findAluminumFinishRules"})
    public void deleteItem(){
        AlumFinishRulesPage alumFinishRulesPage = new AlumFinishRulesPage(driver);
        alumFinishRulesPage.searchByName("[TEST] FINISH");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
        alumFinishRulesPage.selectToggle();
        alumFinishRulesPage.deleteItem();
        Assert.assertEquals(alumFinishRulesPage.getNoDataText(), "NO DATA AVAILABLE", "No such message");
    }



}
