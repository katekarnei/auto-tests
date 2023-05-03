package assemblyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    public WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver=driver;
    }

    public By loginField = By.xpath("//*[@id='user_email']");

    public By passwordField = By.xpath("//*[@id='user_password']");

    public By loginButton = By.xpath("//*[@value='Log in']");

    public By errorAlert = By.xpath("//*[@id='signin']/div[1]/div/div[1]");

    public void setLogin(String login){
        driver.findElement(loginField).sendKeys(login);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public String getErrorAlert(){
        return driver.findElement(errorAlert).getText();
    }
}
