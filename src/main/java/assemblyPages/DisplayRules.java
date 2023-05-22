package assemblyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisplayRules {
    public WebDriver driver;

    public DisplayRules(WebDriver driver){
        this.driver=driver;
    }

    private By createButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-display-rules-action-buttons-id!='']/a[@title='Create']/p");
    public void clickCreateButton(){
        driver.findElement(createButton).click();

    }

    private By namePencilButton = By.xpath("(//table[2]/tbody/tr[@data-global-display-rule-id!='']//div[@data-global-display-rule-name-id!='']//p[@title and not(contains(.,'Save'))]/following-sibling::i)[1]");
    //(//table[2]/tbody/tr[not(contains(@style,'display: none'))]//div[not(contains(@style,'display: none'))]//p[@title and not(contains(.,'Save'))]/following-sibling::i)[1] old locator

    private By filledItemName = By.xpath("//table[2]//tbody/tr[@data-global-display-rule-id!=''][1]//td[@data-global-display-rule-field_name__name]//p[@data-global-display-rule-name-text_value!='']");
    ////table[2]//tbody/tr[@style!='display: none'][1]/td[@data-global-display-rule-field_name__name]/div[@data-global-display-rule-name-id and @style!='display: none']/div/p old
    private By ItemName = By.xpath("(//table[2]/tbody/tr[not(contains(@style,'display: none'))]//div[not(contains(@style,'display: none'))]//input)[3]");
    public void clickNameItemPencil(){
        driver.findElement(namePencilButton).click();
    }
    public void setItemName(String itemName){
        driver.findElement(ItemName).sendKeys(itemName);
        driver.findElement(ItemName).sendKeys(Keys.ENTER);
    }

    private By searchDisplayRulesBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div/div[@class='v3-table-button-bar-group' and @data-global-display-rules-filters-id!='']//input[@data-global-display-rules-filters-search and @placeholder='SEARCH...']");
    //    private By searchDisplayRulesBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div/div[@class='v3-table-button-bar-group' and @style!='display: none']//input[@data-global-display-rules-filters-search]");old
    public void searchNameItem(String itemName){
        driver.findElement(searchDisplayRulesBar).click();
        driver.findElement(searchDisplayRulesBar).sendKeys(itemName);
        driver.findElement(searchDisplayRulesBar).sendKeys(Keys.ENTER);
    }

    boolean resultContainsVariable;
    public boolean searchRes(String variable1){
        WebElement searchResults = driver.findElement(filledItemName);

        if (!searchResults.getText().contains(variable1)) {
            resultContainsVariable = true;
            System.out.println("Test 3: Search result doesn't correspond to the search request");}
        else
            System.out.println("Test 3: Search result corresponds to the search request");
        return resultContainsVariable;
    }

    private By toggleSwitch = By.xpath("//table[2]//tbody/tr[@data-global-display-rule-id!=''][1]/td/div/label[@class='slider-checkbox']//span[@class='thumb']");
    //    private By toggleSwitch = By.xpath("//table[2]//tbody/tr[@style!='display: none'][1]/td/div/label[@class='slider-checkbox']//span[@class='thumb']"); old
    public void selectToggle(){
        driver.findElement(toggleSwitch).click();
    }

    private By deleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-display-rules-action-buttons-id!='']/a[@title='Delete']/p");
    //    private By deleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-display-rules-action-buttons-id and @style!='display: none']/a[@title='Delete']/p");old
    public void deleteAnItem(){
        driver.findElement(deleteButton).click();
    }

    private By noDataAvailable = By.xpath("//table[2]/tbody/tr[@data-global-display-rule-id!='']/td[8]");
    ////table[2]/tbody/tr[@data-global-display-rule-id and @style!='display: none']/td[8]old
    public String getNoDataText(){
        return driver.findElement(noDataAvailable).getText();
    }





}
