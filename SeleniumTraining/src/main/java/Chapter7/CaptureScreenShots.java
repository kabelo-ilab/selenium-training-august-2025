package Chapter7;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CaptureScreenShots {
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://ironspider.ca/forms/dropdowns.htm");
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        File sourceFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

       String imageName = "_" + timeStamp + ".png";

        //Test Image_20250827_115335.png
        File destinationFile = new File("src/main/resources/ScreenShots/Test image" + imageName);//path

        //Move file from memory to physical location (hard drive)
        try {
            Files.move(sourceFile, destinationFile);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
