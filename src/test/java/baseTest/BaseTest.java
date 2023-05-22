package baseTest;

import assemblyPages.HomePage;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import assemblyPages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class BaseTest {
        // Load the .env file
        Dotenv dotenv = Dotenv.configure().load();

        // Access environment variables
       public String userName = dotenv.get("USERNAME");
        public String passCode = dotenv.get("PASSWORD");
        public WebDriver driver;
        public HomePage homePage;
        public LogInPage logInPage;
        @BeforeClass
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.get("https://beta.eswindows.co/login");
            driver.manage().window().maximize();
            logInPage = new LogInPage(driver);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test(priority = 1)
        public void validLoginTests(){
            logInPage.setLogin(userName);
            logInPage.setPassword(passCode);
            homePage = logInPage.clickLoginButton();
            System.out.println("Test 1: Signed in successfully");
        }


        @AfterClass
        public void exitBrowser(){
            driver.quit();
        }
    }

