package elements;

import constants.TableLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private By locator;

    public WebDriver driver;

    public Table(String name, By locator, WebDriver driver) {
        this.name = name;
        this.locator = locator;
        this.driver = driver;
    }

    private WebElement getTable() {
        return driver.findElement(locator);
    }

    public List<WebElement> getAllColumnCells(String column) {
        return getTable().findElements(By.xpath(String.format(TableLocators.CELL_BY_COLUMN_LOCATOR, getColumnIndex(column))));
    }

    public void clickOnHeader(String column) {
        WebElement headerElement = getTable().findElement(By.xpath(String.format(TableLocators.HEADERS_LOCATOR, column)));
        headerElement.click();
    }

    public List<String> getAllColumnValues(String column) {
        List<String> list = new ArrayList<>();
        getAllColumnCells(column).forEach(cell -> list.add(cell.getText()));
        return list;
    }

    private int getColumnIndex(String column) {
        List<WebElement> list = getTable().findElements(By.xpath(String.format(TableLocators.HEADERS_LOCATOR, "")));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(column)) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException(String.format("Column '%s' not found", column));
    }

}
