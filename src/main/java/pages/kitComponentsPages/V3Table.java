package pages.kitComponentsPages;

import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import elements.Table;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;


public abstract class V3Table {
    public WebDriver driver;
    public By CREATE_BUTTON_LOCATOR;
    public By DELETE_BUTTON_LOCATOR;
    public By xPathOfToggleButton;
    public By xPathNoDataText;
    public By xPathTable;
    public By TABLE_LOCATOR;
    public By xPathOfTableHeaders;
    public String SEARCH_FIELD_LOCATOR;
    public String xPathOfClickableHeader;
    public By TOGGLE_BUTTON;

    public V3Table(WebDriver driver) {
        this.driver = driver;
    }
    public void searchItem(String value){
        WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD_LOCATOR));
        searchField.sendKeys(value + Keys.ENTER);
    }
    public WebElement findTable(){
        return driver.findElement(TABLE_LOCATOR);
    }

    public void createNewItem() {
        driver.findElement(CREATE_BUTTON_LOCATOR).click();
    }

    public void deleteItem() {
        driver.findElement(DELETE_BUTTON_LOCATOR).click();
    }

    //selectToggleButton method will work only with searchItem precondition
    public void selectToggleButton() {
        driver.findElement(xPathOfToggleButton).click();
    }

    public String getNoDataText() {
        return driver.findElement(xPathNoDataText).getText();
    }

    public void sortingMethod(String column, WebDriver driver1) {
        Table tableV3 = new Table("V3 table", By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody"), driver1);
        tableV3.clickOnHeader(column);
        List<String> columnAsc = tableV3.getAllColumnValues(column);
        Assert.assertTrue("cортировка по возрастанию", Comparators.isInOrder(columnAsc, Ordering.natural()));
        tableV3.clickOnHeader(column);
        List<String> columnDesc = tableV3.getAllColumnValues(column);
        Assert.assertTrue("cортировка по убыванию", Comparators.isInOrder(columnDesc, Ordering.natural().reversed()));
    }
}






