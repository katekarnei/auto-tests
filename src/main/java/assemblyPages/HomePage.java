package assemblyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    private By kits = By.xpath("//div[@id='sidebar-default']//div[contains(@class,'menu-section--configuration')]//ul[@class='submenu fullmenu active']//span[normalize-space()='Kits']");
    private By balanceRules = By.xpath("//a[@href='/admin/v3/global_balance_rules/index']");
    private By sortBalanceType = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@data-global-balance-rules-sort_by__balance_type]");
    private By sortAscType = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@data-global-balance-rules-sort_by__balance_type]");
    private By createdAt = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@class='created-at-col sticky-col w-em-17 sortable']");
    private By searchBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@class='v3-table-button-bar-group' and @style!='display: none']/label/input[@placeholder='SEARCH...']");
    private By displayRules = By.xpath("//a[@href='/admin/v3/global_display_rules/index']");

   public void clickKits(){
       driver.findElement(kits).click();
   }
   public void clickBalanceRules(){
       driver.findElement(balanceRules).click();
   }
   public void clickDisplayRules(){driver.findElement(displayRules).click();}
   public void setSortBalanceType(){
       driver.findElement(sortBalanceType).click();
   }
   public void setSortAscType(){
       driver.findElement(sortAscType).click();
   }
   public void clickCreatedAt(){
       driver.findElement(createdAt).click();
   }


   public void sendKeysSearchBar(String variable){
       driver.findElement(searchBar).click();
       driver.findElement(searchBar).sendKeys(variable);
   }
   public void clickEnter(){
       driver.findElement(searchBar).sendKeys(Keys.ENTER);
   }
    boolean allResultsContainQuery;
 public boolean searchRes(String variable1){
    WebElement searchResults = driver.findElement(sortBalanceType);

    if (!searchResults.getText().contains(variable1)) {
            allResultsContainQuery = true;
        System.out.println("Search results do not correspond to the search request");}
    else
        System.out.println("Search results correspond to the search request");
    return allResultsContainQuery;
        }

    }


