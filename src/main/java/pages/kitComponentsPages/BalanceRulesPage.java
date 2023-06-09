package pages.kitComponentsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class BalanceRulesPage extends V3Table {
    public WebDriver driver;

    public BalanceRulesPage(WebDriver driver){
        super(driver);
        //this.xPathNameColumnHeader = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@data-global-balance-rules-sort_by__balance_type]/div");
        //this.xPathTable = By.xpath("//table[ @data-global-balance-rules-id!='' and  @style!='display: none']");
        this.xPathOfTable = By.xpath("//table[ @data-global-balance-rules-id!='' and  @style!='display: none']");
        this.xPathOfTableHeaders = By.xpath("//thead/tr");
        this.xPathOfClickableHeader = "//thead/tr/th[%d]";
    }


    private By sortBalanceType = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@data-global-balance-rules-sort_by__balance_type]");
    private By createdAt = By.xpath("//table[@class='v3-table' and @style!='display: none']/thead/tr/th[@class='created-at-col sticky-col w-em-17 sortable']/div");
    private By searchBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@class='v3-table-button-bar-group' and @style!='display: none']/label/input[@placeholder='SEARCH...']");


    public void sendKeysSearchBar(String variable){
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys(variable + Keys.ENTER);
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
