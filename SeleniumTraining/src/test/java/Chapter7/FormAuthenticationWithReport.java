package Chapter7;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
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
public class FormAuthenticationWithReport {

    static WebDriver driver;
    static ExtentReports extent;
    static ExtentSparkReporter rptSpark;
    boolean isTestPass;
    static String reportURL = "src/test/resources/Reports/Login Spark Report.html";
    String assertMessage;

    @BeforeAll
    static void setup(){
        extent = new ExtentReports();
        rptSpark = new ExtentSparkReporter(reportURL);
        rptSpark.config().setReportName("Test Progress Report");
        rptSpark.config().setDocumentTitle("Login Feature Report");
        extent.attachReporter(rptSpark);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterAll
    static void tearDown(){
        extent.flush();

        try {
            Desktop.getDesktop().browse(new File(reportURL).toURI());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @AfterEach
    void createReport(TestInfo info){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        ExtentTest myTest = extent.createTest(info.getDisplayName());

        String sourceImage = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.BASE64);

        //Set status for the test
        if (isTestPass){
            myTest.log(Status.PASS, "Test Passed");
        }else{
            myTest.log(Status.FAIL, assertMessage);
        }

        myTest.addScreenCaptureFromBase64String(sourceImage);

    }

    @Test
    @DisplayName("TC1 - Verify that home page is open")
    @Order(1)
    void verifyPageLoad(){
        //Arrange
        String expectedURL = "https://the-internet.herokuapp.com/";
        //Actual
        String actualURL = driver.getCurrentUrl() + "xxx";
        //Assert
        isTestPass = actualURL.equals(expectedURL);
        assertMessage = "The expected URL is: '" + expectedURL + "'. Actual URL (" + actualURL + ")";
        assertEquals(expectedURL, actualURL, assertMessage);

    }

    @Test
    @DisplayName("TC2 - Open Login Page")
    @Order(2)
    void openLoginPage(){
        String expected = "Login Page";

        driver.findElement(By.cssSelector("a[href='/login']")).click();

       WebElement lblHeading = driver.findElement(By.cssSelector("div[class='example'] h2"));

       String actual = lblHeading.getText() + "p";

       isTestPass = actual.equals(expected);
        assertMessage = "The expected text is: '" + expected + "'.  Actual text (" + actual + ")";
       assertEquals(expected, actual, assertMessage);
    }

    @Test
    @DisplayName("TC3 - Verify valid login")
    @Order(3)
    void verifyLogin(){

        String expected = "https://the-internet.herokuapp.com/secure";

        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        String actual = driver.getCurrentUrl() + ".com";

        isTestPass = actual.equals(expected);
        assertMessage = "The expected URL is: '" + expected + "'.  Actual URL (" + actual + ")";
        assertEquals(expected, actual, assertMessage);

    }
}
