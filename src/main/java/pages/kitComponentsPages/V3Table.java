package pages.kitComponentsPages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public abstract class V3Table {
    public WebDriver driver;
    public By xPathOfCreateButton;
    public By xPathOfDeleteButton;
    public By xPathOfToggleButton;
    public By xPathNoDataText;

    public V3Table(WebDriver driver){
        this.driver=driver;
    }


    public void clickCreateButton(){
        driver.findElement(xPathOfCreateButton).click();
    }
    public void clickDeleteButton(){
        driver.findElement(xPathOfDeleteButton).click();
    }
    public void selectToggleButton(){
        driver.findElement(xPathOfToggleButton).click();
    }
    public String getNoDataText(){
         return driver.findElement(xPathNoDataText).getText();
    }

    public void testColumnsSorting(){
        List<WebElement> sortableColumnHeaders = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/thead/tr/th[contains(@class, 'sortable')]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for(WebElement sortableColumn : sortableColumnHeaders){
            for(int i = 0; i<3; i++){
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
                List<WebElement> names = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody/tr[@style!='display: none']/td[1]"));
                String[] namesBeforeSort = new String[names.size()];
                for(int j = 0; j< names.size(); j++){
                    namesBeforeSort[j] = names.get(j).getText();
                }
                sortableColumn.click();
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
                String classValue = sortableColumn.getAttribute("class");
                if(classValue.contains("asc")){
                    Arrays.sort(namesBeforeSort);
                } else if(classValue.contains("desc")){
                    Arrays.sort(namesBeforeSort, Collections.reverseOrder());
                } else break;

                List<WebElement> name = driver.findElements(By.xpath("//table[@style!='display: none' and @class='v3-table']/tbody/tr[@style!='display: none']/td[1]"));
                String[] namesAfterSort = new String[names.size()];
                for(int k = 0; k< name.size(); k++){
                    namesAfterSort[k] = name.get(k).getText();
                }
                boolean arraysEqual = Arrays.equals(namesBeforeSort,namesAfterSort);
                assertTrue(arraysEqual);




            }
        }

    }



}

