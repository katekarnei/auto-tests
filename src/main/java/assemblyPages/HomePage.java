package assemblyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public By signedInText = By.xpath("//*[contains(text(),'Signed in successfully')]");

   public String getSignedinTest(){
       return driver.findElement(signedInText).getText();
   }
}
