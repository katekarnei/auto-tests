package assemblyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GlassRules {
    public WebDriver driver;

    public GlassRules(WebDriver driver){
        this.driver=driver;
    }

    private By createButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_action_buttons_container!='']//a[@data-global-glass-visibility-rules-action-buttons-create_button!='']");
    private By deleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_action_buttons_container!='']//a[@data-global-glass-visibility-rules-action-buttons-delete_button!='']");
    private By searchField = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_filters_container!='']/div[@data-global-glass-visibility-rules-filters-id!='']/label/input");
    private By pencilButton = By.xpath("(//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//i[@data-global-glass-visibility-rule-glass-name-edit_button!=''])[1]");
    private By selectDropdown = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//div[@data-global-glass-visibility-rule-glass-name-edit_container!='']/div//span[@class='selection']");
    private By dropdownSearchField = By.xpath("//span[@class='select2-dropdown select2-dropdown--below']//input[@class='select2-search__field']");
    private By saveButton = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//div[@data-global-glass-visibility-rule-glass-name-edit_container!='']/div/a[@title='Save']");
    private By searchText = By.xpath("//td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//p[not(contains(text(), 'Save'))]");
    private By toggleButton = By.xpath("//tr[@data-global-glass-visibility-rule-id!='']/td//span[@class='thumb']");
    private By noDataText = By.xpath("//td[normalize-space()='No data available']");
    private By glassRuleNameHeader = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/thead/tr/th[@data-global-glass-visibility-rules-sort_by__glass_name!='']/div");



    public void clickCreateButton(){
        driver.findElement(createButton).click();
    }
    public void clickPencilButton(){
        driver.findElement(pencilButton).click();
    }
    public void clickDropdown(){
        driver.findElement(selectDropdown).click();
    }
    public void searchValue(String searchValue){
        driver.findElement(dropdownSearchField).click();
        driver.findElement(dropdownSearchField).sendKeys(searchValue);
    }
    public void saveInput(){
        driver.findElement(dropdownSearchField).sendKeys(Keys.ENTER);
        driver.findElement(saveButton).click();
    }
    public void searchItem(String searchValue){
        driver.findElement(searchField).sendKeys(searchValue + Keys.ENTER);
    }
    public String getSearchText(){
        return driver.findElement(searchText).getText();

    }
    public void selectToggle(){
        driver.findElement(toggleButton).click();
    }
    public void deleteItem(){
        driver.findElement(deleteButton).click();
    }
    public String findNoDataText(){
        return driver.findElement(noDataText).getText();
    }

    public void sortName(){
        driver.findElement(glassRuleNameHeader).click();
        String classValue = driver.findElement(glassRuleNameHeader).getAttribute("class");
        if (classValue.equals("asc")){
            System.out.println("The element contains the value 'asc'.");

        } else if (classValue.equals("desc")){
            System.out.println("The element contains the value 'desc'.");
        } else {
            System.out.println("Sorting has failed");
        }
    }




}
