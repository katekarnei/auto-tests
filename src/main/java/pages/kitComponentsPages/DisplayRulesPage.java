package pages.kitComponentsPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pages.V3Table;

import java.util.List;

public class DisplayRulesPage extends V3Table {
    public WebDriver driver;

    public DisplayRulesPage(WebDriver driver){
        super(driver);
        this.xPathNameColumnHeader = By.xpath("//table[2]/thead//th[@data-global-display-rules-sort_by__name!='']/div");
        this.xPathOfCreateButton =  By.xpath("//div[@class='v3-table-wrapper']/div[@class='v3-table-button-bar-wrapper']//div[@data-global-display-rules-action-buttons-id!='' and @class='v3-table-button-bar-group' ]//a[@title='Create']");
        this.xPathOfDeleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-display-rules-action-buttons-id!='']/a[@title='Delete']/p");
        this.xPathOfToggleButton = By.xpath("//table[2]//tbody/tr[@data-global-display-rule-id!=''][1]/td/div/label[@class='slider-checkbox']//span[@class='thumb']");
        this.xPathNoDataText = By.xpath("//table[2]/tbody/tr[@data-global-display-rule-id!='']/td[8]");
    }

    private By namePencilButton = By.xpath("(//table[2]/tbody/tr[@data-global-display-rule-id!='']//div[@data-global-display-rule-name-id!='']//p[@title and not(contains(.,'Save'))]/following-sibling::i)[1]");
    private By filledItemName = By.xpath("//table[2]//tbody/tr[@data-global-display-rule-id!=''][1]//td[@data-global-display-rule-field_name__name]//p[@data-global-display-rule-name-text_value!='']");
    private By ItemName = By.xpath("(//table[2]/tbody/tr[not(contains(@style,'display: none'))]//div[not(contains(@style,'display: none'))]//input)[3]");
    private By searchDisplayRulesBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div/div[@class='v3-table-button-bar-group' and @data-global-display-rules-filters-id!='']//input[@data-global-display-rules-filters-search and @placeholder='SEARCH...']");
    private By qTypePencilButton = By.xpath("(//table[2]//td[@data-global-display-rule-field_name__rule_type!=''][1]//div[@data-global-display-rule-rule-type-id!='']//i)[1]");
    private By selectqType = By.xpath("(//table[2]//td[@data-global-display-rule-field_name__rule_type!=''][1]//div[@data-global-display-rule-rule-type-id!='']//div[@class='v3-edit-cell v3-edit-dropdown-cell']//label/select)[1]");
    private By minPencilButton = By.xpath("(//table[2]/tbody/tr[@data-global-display-rule-id!='']//td[@data-global-display-rule-field_name__minimum!='']//div[@data-global-display-rule-minimum-id!='']//p//following-sibling::i)[1]");
    private By minInputField = By.xpath("(//table[2]//tr[@data-global-display-rule-id!='']//td[@data-global-display-rule-field_name__minimum!='']//div[@data-global-display-rule-minimum-edit_container!='']//input)[1]");
    private By maxPencilButton = By.xpath("(//table[2]/tbody/tr[@data-global-display-rule-id!='']//td[@data-global-display-rule-field_name__maximum!='']//div[@data-global-display-rule-maximum-id!='']//p/following-sibling::i)[1]");
    private By maxInputField = By.xpath("(//table[2]/tbody/tr[@data-global-display-rule-id!='']//td[@data-global-display-rule-field_name__maximum!='']//div[@data-global-display-rule-maximum-id!='']//div[@data-global-display-rule-maximum-edit_container!='']//input)[1]");
    private By searchItemName = By.xpath("//table[2]/tbody/tr[@data-global-display-rule-id!='']/td[@data-global-display-rule-field_name__name!='']/div[@data-global-display-rule-name-id!='']/div/p");



    public void setItemName(String itemName){
        WebElement element = driver.findElement(namePencilButton);
        element.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("console.log(jQuery(arguments[0]));", element);
        driver.findElement(ItemName).clear();
        driver.findElement(ItemName).sendKeys(itemName + Keys.ENTER);

    }


    public void editItemName(String editedName){
        driver.findElement(ItemName).clear();
        driver.findElement(ItemName).sendKeys(editedName + Keys.ENTER);
    }

    public void searchingTest(String searchValue){
        driver.findElement(searchDisplayRulesBar).click();
        driver.findElement(searchDisplayRulesBar).sendKeys(searchValue + Keys.ENTER);
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

    public void clickQTypePencil(){
        driver.findElement(qTypePencilButton).click();
    }

    public void  clickSelectDropdown(String dropdownValue){
        WebElement selectElement = driver.findElement(selectqType);
        Select select = new Select(selectElement);
        List<WebElement> optionList = select.getOptions();
        select.selectByVisibleText(dropdownValue);
        selectElement.sendKeys(Keys.ENTER);
    }

    public void clickMinPencilButton(){
        driver.findElement(minPencilButton).click();
    }

    public void setMinValue(String minimumValue){
        driver.findElement(minInputField).clear();
        driver.findElement(minInputField).sendKeys(minimumValue + Keys.ENTER);
    }

    public void clickMaxPencilButton(){
        driver.findElement(maxPencilButton).click();
    }

    public void setMaxValue(String maximumValue){
        driver.findElement(maxInputField).clear();
        driver.findElement(maxInputField).sendKeys(maximumValue + Keys.ENTER);
    }

    public String getItemName(){
        return driver.findElement(searchItemName).getText();
    }


}
