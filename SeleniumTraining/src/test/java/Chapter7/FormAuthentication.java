package Chapter7;

import com.google.common.io.Files;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    @AfterEach
    void takeScreenShot(TestInfo info){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        File sourceFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

        String imageName = info.getDisplayName() + "_" + timeStamp + ".png";

        //TC1 - Verify that home page is open_20250827_115335.png
        File destinationFile = new File("src/test/resources/ScreenShots/" + imageName);//path

        System.out.println("Path: " + destinationFile.getPath());
        System.out.println("Abs Path: " + destinationFile.getAbsolutePath());
        //Move file from memory to physical location (hard drive)
        try {
            Files.move(sourceFile, destinationFile);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
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
