package pages.kitComponentsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.V3Table;

public class CutsPage extends V3Table {
    public WebDriver driver;
    public CutsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By cutsTab = By.xpath("//a[@href='/admin/v3/global_cuts/index']");
    private By createCutsButton = By.xpath("//div[@class='v3-table-wrapper']/div[@class='v3-table-button-bar-wrapper']//div[@data-global-cuts-action-buttons-id!='' and @class='v3-table-button-bar-group']//a[@title='Create']");
    private By searchInputField = By.xpath("//div[@class='v3-table-button-bar-wrapper']/div/div[@class='v3-table-button-bar-group' and @data-global-cuts-filters-id!='']/label/input");
    private By cutsNamePencilButton = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr//td[@data-global-cut-field_name__name!='']//div[@data-global-cut-name-id!='']//p[@data-global-cut-name-text_value]//following-sibling::i)[1]");
    private By cutsNameInputField = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr//td[@data-global-cut-field_name__name!='']//div[@data-global-cut-name-id!='']//div[@data-global-cut-name-edit_container!='']//input)[1]");
    private By cutsLeftAnglePencilButton = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__left_angle!='']//i[@data-global-cut-left-angle-edit_button!=''])[1]");
    private By cutsLeftAngleInput = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__left_angle!='']//div[@data-global-cut-left-angle-id!='']//div[@data-global-cut-left-angle-edit_container!='']//input)[1]");
    private By cutsRightAnglePencilButton = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__right_angle!='']//div[@data-global-cut-right-angle-id!='']//i[@data-global-cut-right-angle-edit_button!=''])[1]");
    private By cutsRightAngleInput = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__right_angle!='']//div[@data-global-cut-right-angle-edit_container!='']//input)[1]");
    private By heightPencilButton = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__height!='']//div[@data-global-cut-height-id!='']//i)[1]");
    private By heightInputField = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr/td[@data-global-cut-field_name__height!='']//div[@data-global-cut-height-id!='']//input[@data-global-cut-height-raw_value!=''])[1]");
    private By searchName = By.xpath("(//table[@data-global-cuts-id!='']/tbody/tr[@data-global-cut-id!='']//td[@data-global-cut-field_name__name!='']//p[@data-global-cut-name-text_value!=''])[1]");
    private By sortingByName = By.xpath("//table[2]/thead//th[@data-global-cuts-sort_by__name!='']/div");
    private By toggleSwitch = By.xpath("//table[2]/tbody/tr[@data-global-cut-id!='']/td//label[@class='slider-checkbox']");
    private By deleteButton = By.xpath("//div[@class='v3-table-wrapper']/div[@class='v3-table-button-bar-wrapper']//div[@data-global-cuts-action-buttons-id!='' and @class='v3-table-button-bar-group']//a[@title='Delete']");
    private By noDataAvailable = By.xpath("//table[2]/tbody/tr[@data-global-cut-id!='']/td[normalize-space()='No data available']");


    public void clickCreateButton(){
        driver.findElement(createCutsButton).click();
    }
    public void setCutsName(String cutsValue){
        driver.findElement(cutsNamePencilButton).click();
        driver.findElement(cutsNameInputField).sendKeys(cutsValue + Keys.ENTER);
    }
    public void setLeftAngleValue(String leftAngleValue){
        driver.findElement(cutsLeftAnglePencilButton).click();
        driver.findElement(cutsLeftAngleInput).sendKeys(leftAngleValue + Keys.ENTER);
    }
    public void setRightAngleValue(String rightAngleValue){
        driver.findElement(cutsRightAnglePencilButton).click();
        driver.findElement(cutsRightAngleInput).sendKeys(rightAngleValue + Keys.ENTER);
    }
    public void setHeightValue(String heightValue){
        driver.findElement(heightPencilButton).click();
        driver.findElement(heightInputField).sendKeys(heightValue + Keys.ENTER);
    }
    public void searchCuts(String searchValue){
        driver.findElement(searchInputField).sendKeys(searchValue + Keys.ENTER);
    }
    public String getCutsName(){
        return driver.findElement(searchName).getText();
    }
    public void sortByName() {
        driver.findElement(sortingByName).click();
        String sortValue = driver.findElement(sortingByName).getAttribute("class");
        if (sortValue.equals("asc")) {
            System.out.println("The element contains the value 'asc'.");

        } else if (sortValue.equals("desc")) {
            System.out.println("The element contains the value 'desc'.");
        } else {
            System.out.println("Sorting has failed");
        }
    }
    public void selectToggleButton(){
        driver.findElement(toggleSwitch).click();
    }
    public void clickDeleteButton(){
        driver.findElement(deleteButton).click();
    }
    public String getNoDataText(){
        return driver.findElement(noDataAvailable).getText();
    }










}
