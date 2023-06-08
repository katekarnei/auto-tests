package pages.kitComponentsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.V3Table;

public class GlassRulesPage extends V3Table {
    public WebDriver driver;

    public GlassRulesPage(WebDriver driver){
        super(driver);
        this.xPathOfCreateButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_action_buttons_container!='']//a[@data-global-glass-visibility-rules-action-buttons-create_button!='']");
        this.xPathOfDeleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_action_buttons_container!='']//a[@data-global-glass-visibility-rules-action-buttons-delete_button!='']");
        this.xPathOfToggleButton = By.xpath("//tr[@data-global-glass-visibility-rule-id!='']/td//span[@class='thumb']");
        this.xPathNoDataText = By.xpath("//td[normalize-space()='No data available']");
        this.xPathNameColumnHeader = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/thead/tr/th[@data-global-glass-visibility-rules-sort_by__glass_name!='']/div");

    }

    private By searchField = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_filters_container!='']/div[@data-global-glass-visibility-rules-filters-id!='']/label/input");
    private By pencilButton = By.xpath("(//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//i[@data-global-glass-visibility-rule-glass-name-edit_button!=''])[1]");
    private By selectDropdown = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//div[@data-global-glass-visibility-rule-glass-name-edit_container!='']/div//span[@class='selection']");
    private By dropdownSearchField = By.xpath("//span[@class='select2-dropdown select2-dropdown--below']//input[@class='select2-search__field']");
    private By saveButton = By.xpath("//table[@data-global-glass-visibility-rules-id!='']/tbody/tr[@data-global-glass-visibility-rule-id!='']/td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//div[@data-global-glass-visibility-rule-glass-name-edit_container!='']/div/a[@title='Save']");
    private By searchText = By.xpath("//td[@data-global-glass-visibility-rule-field_name__glass_name!='']/div[@data-global-glass-visibility-rule-glass-name-id!='']//p[not(contains(text(), 'Save'))]");



    public void clickPencilButton(){
        driver.findElement(pencilButton).click();
    }
    public void clickDropdown(){
        driver.findElement(selectDropdown).click();
    }
    public void searchDropdownValue(String searchValue){
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




}
