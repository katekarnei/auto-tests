package pages.kitComponentsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.V3Table;

public class GlobalLengthVariables extends V3Table {
    public WebDriver driver;

    public GlobalLengthVariables(WebDriver driver){
        super(driver);
        this.driver=driver;
        this.xPathOfCreateButton = By.xpath("//div[@data-base-wrapper-table_action_buttons_container]//div[@data-global-machining-variables-action-buttons-id!='']/a[@title='Create']");
        this.xPathOfDeleteButton = By.xpath("//div[@data-base-wrapper-table_action_buttons_container]//div[@data-global-machining-variables-action-buttons-id!='']/a[@title='Delete']");
    }

    private By subTableButton = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[1]/td[@class='toggle-col sticky-col']/div");
    private By nameEditButton = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[1]/td[@data-global-machining-variable-field_name__name]//div[@data-global-machining-variable-name-id!='']//i[@data-global-machining-variable-name-edit_button]");
    private By nameDropdownList = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[1]/td[@data-global-machining-variable-field_name__name]//div[@data-global-machining-variable-name-id!='']/div[@class='v3-edit-cell v3-edit-dropdown-cell']//label");
    private By descriptionEditButton = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[1]/td[@data-global-machining-variable-field_name__description]//div[@data-global-machining-variable-description-id!='']//i[@data-global-machining-variable-description-edit_button]");
    private By descriptionInputField = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[1]/td[@data-global-machining-variable-field_name__description]//div[@data-global-machining-variable-description-id!='']//div[@class='v3-edit-cell v3-edit-text-cell']//input");
    private By variablesSubtableButton = By.xpath("//tbody[@data-global-machining-variables-container!='']/tr[@data-global-machining-variable-values-subtable-title-id!='']//div[@data-global-machining-variable-values-subtable-title-toggle]/i");
    private By subTableCreationButton = By.xpath("//tbody[@data-global-machining-variables-container!='']//tr[@data-global-machining-variable-values-id!='' and @class='v3-subtable-row']/td//table/thead//i[@data-global-machining-variable-values-create_button]");
    String baseSubTableLocator = "//tbody[@data-global-machining-variables-container!='']//tr[@data-global-machining-variable-values-id!='' and @class='v3-subtable-row']/td//table/tbody/tr[@data-global-machining-variable-value-id!='']";
    String sequenceNumber = baseSubTableLocator + "/td[@data-global-machining-variable-value-field_name__sequence_number!='']//div[@data-global-machining-variable-value-sequence-number-id!='']/div/i";




}
