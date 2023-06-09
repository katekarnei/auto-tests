package pages.kitComponentsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AlumFinishRulesPage extends V3Table {
    public WebDriver driver;
    public AlumFinishRulesPage(WebDriver driver){
        super(driver);
        this.xPathOfCreateButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-aluminum-finish-visibility-rules-action-buttons-id!='']/a[@title='Create']");
        this.xPathOfDeleteButton = By.xpath("//div[@class='v3-table-button-bar-wrapper']//div[@data-base-wrapper-table_action_buttons_container]/div[@data-global-aluminum-finish-visibility-rules-action-buttons-id!='']/a[@title='Delete']");
        this.xPathOfToggleButton = By.xpath("//table[@data-global-aluminum-finish-visibility-rules-id!='']/tbody/tr[@data-global-aluminum-finish-visibility-rule-id!='']//label[@class='slider-checkbox']//span[@class='thumb']");
        this.xPathNoDataText = By.xpath("//table[@data-global-aluminum-finish-visibility-rules-id!='']/tbody/tr[@data-global-aluminum-finish-visibility-rule-id!='']//td[normalize-space()='No data available']");
        //this.xPathNameColumnHeader = By.xpath("//table[@data-global-aluminum-finish-visibility-rules-id!='']/thead/tr[1]/th[@data-global-aluminum-finish-visibility-rules-sort_by__aluminum_finish_name]/div");


    }
    private By namePencilButton = By.xpath("//div[@data-base-wrapper-table_container]/table[@style!='display: none']/tbody/tr[1]/td[@data-global-aluminum-finish-visibility-rule-field_name__aluminum_finish_name!='']//i[@data-global-aluminum-finish-visibility-rule-aluminum-finish-name-edit_button!='']");
    private By selectionDropdown = By.xpath("//div[@data-base-wrapper-table_container]/table[@style!='display: none']/tbody/tr[1]/td[@data-global-aluminum-finish-visibility-rule-field_name__aluminum_finish_name!='']//div[@data-global-aluminum-finish-visibility-rule-aluminum-finish-name-edit_container!='']//span[@class='select2-selection select2-selection--single']");
    private By saveButton = By.xpath("//div[@data-base-wrapper-table_container]/table[@style!='display: none']/tbody/tr[1]/td[@data-global-aluminum-finish-visibility-rule-field_name__aluminum_finish_name!='']//div[@data-global-aluminum-finish-visibility-rule-aluminum-finish-name-edit_container!='']//a[@title='Save']");
    private By dropdownInput = By.xpath("//body//span[@class='select2-container select2-container--default select2-container--open']//input[@class='select2-search__field']");
    private By searchBar = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div[@data-base-wrapper-table_filters_container!='']//div[@data-global-aluminum-finish-visibility-rules-filters-id!='']//input[@data-global-aluminum-finish-visibility-rules-filters-search]");
    private By nameAfterSearch = By.xpath("//table[@data-global-aluminum-finish-visibility-rules-id!='']/tbody/tr[@data-global-aluminum-finish-visibility-rule-id!='']//td[@data-global-aluminum-finish-visibility-rule-field_name__aluminum_finish_name!='']//p[@data-global-aluminum-finish-visibility-rule-aluminum-finish-name-text_value!='']");



    public void clickNamePencilButton(){
        driver.findElement(namePencilButton).click();
    }

    public void setRuleName(String aluminumFinish){
        driver.findElement(selectionDropdown).click();
        driver.findElement(dropdownInput).sendKeys(aluminumFinish);
    }

    public void saveNameItem(){
        driver.findElement(dropdownInput).sendKeys(Keys.ENTER);
        driver.findElement(saveButton).click();
    }
    public void searchByName(String searchValue){
        driver.findElement(searchBar).sendKeys(searchValue + Keys.ENTER);
    }

    public String getSearchResults(){
        return driver.findElement(nameAfterSearch).getText();
    }


}
