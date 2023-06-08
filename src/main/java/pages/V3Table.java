package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class V3Table {
    public WebDriver driver;
    public By xPathOfCreateButton;
    public By xPathOfDeleteButton;
    public By xPathOfToggleButton;
    public By xPathNoDataText;
    public By xPathNameColumnHeader;

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
    public void sortByName(){
        List<WebElement> sortableColumnHeaders = driver.findElements(By.xpath("//table[2]/thead/tr/th[contains(@class, 'sortable')]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for(WebElement sortableColumn : sortableColumnHeaders){
            for(int i = 0; i<3; i++){
                sortableColumn.click();
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("tr.v3-loader"))));
                String classValue = sortableColumn.getAttribute("class");
                switch (classValue){
                    case "asc":
                        System.out.println("The element contains the value 'asc'.");
                        break;
                    case "desc":
                        System.out.println("The element contains the value 'desc'.");
                        break;
                    case "":
                        System.out.println("Sorting has ended.");
                        break;
                }

                try {
                    Thread.sleep(1000); //pause in milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }



}
