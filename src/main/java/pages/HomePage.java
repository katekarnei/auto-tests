package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    private By kits = By.xpath("//div[@id='sidebar-default']//div[contains(@class,'menu-section--configuration')]//span[normalize-space()='Kits']");
    private By balanceRules = By.xpath("//a[@href='/admin/v3/global_balance_rules/index']");
    private By displayRules = By.xpath("//a[@href='/admin/v3/global_display_rules/index']");
    private By cutsTab = By.xpath("//a[@href='/admin/v3/global_cuts/index']");
    private By aluminumFinishRules = By.xpath("//a[@href='/admin/v3/global_aluminum_finish_visibility_rules/index']");
    private By globalGlassRules = By.xpath("//a[@href='/admin/v3/global_glass_visibility_rules/index']");


    public void clickKits(){
       driver.findElement(kits).click();
   }
   public void clickBalanceRules(){
       driver.findElement(balanceRules).click();
   }
   public void clickDisplayRules(){driver.findElement(displayRules).click();}

   public void clickCutsTab(){
        driver.findElement(cutsTab).click();
   }

    public void clickAluminumFinish(){
        driver.findElement(aluminumFinishRules).click();
    }
    public void clickGlassRules(){
        driver.findElement(globalGlassRules).click();
    }



    }


