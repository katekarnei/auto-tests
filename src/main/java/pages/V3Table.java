package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class V3Table {
    public WebDriver driver;
    private By xPathOfCreateButton;
    private By xPathOfDeleteButton;
    private By xPathOfToggleButton;
    private By xPathNoDataText;
    private By xPathNameColumnHeader;


    public V3Table(WebDriver driver){
        this.driver=driver;
    }
    protected void clickCreateButton(){
        driver.findElement(xPathOfCreateButton).click();
    }
    protected void clickDeleteButton(){
        driver.findElement(xPathOfDeleteButton).click();
    }
    protected void selectToggleButton(){
        driver.findElement(xPathOfToggleButton).click();
    }
    protected String getNoDataText(){
         return driver.findElement(xPathNoDataText).getText();
    }
    protected void sortByName(){
        driver.findElement(xPathNameColumnHeader).click();
        String classValue = driver.findElement(xPathNameColumnHeader).getAttribute("class");
        if (classValue.equals("asc")){
            System.out.println("The element contains the value 'asc'.");

        } else if (classValue.equals("desc")){
            System.out.println("The element contains the value 'desc'.");
        } else {
            System.out.println("Sorting has failed");
        }
    }



}
