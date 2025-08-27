package Chapter6;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class will automate the login functionality from
 * this site {@link https://the-internet.herokuapp.com/}
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormAuthentication {

    static WebDriver driver;
    @BeforeAll
    static void loadBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    @DisplayName("TC1 - Verify that home page is open")
    @Order(1)
    void verifyPageLoad(){
        //Arrange
        String expectedURL = "https://the-internet.herokuapp.com/";
        //Actual
        String actualURL = driver.getCurrentUrl();
        //Assert
        assertEquals(expectedURL, actualURL);
    }

    @Test
    @DisplayName("TC2 - Open Login Page")
    @Order(2)
    void openLoginPage(){
        String expected = "Login Page";

        driver.findElement(By.cssSelector("a[href='/login']")).click();

       WebElement lblHeading = driver.findElement(By.cssSelector("div[class='example'] h2"));

       String actual = lblHeading.getText();

       assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TC3 - Verify valid login")
    @Order(3)
    void verifyLogin(){

        String expected = "https://the-internet.herokuapp.com/secure";

        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        String actual = driver.getCurrentUrl();

        assertEquals(expected, actual);

    }
}
