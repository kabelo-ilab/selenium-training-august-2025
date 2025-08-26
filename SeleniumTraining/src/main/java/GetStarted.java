import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class GetStarted {
    public static void main(String[] args) {
        //Instantiate a webdriver object
        WebDriver driver = new ChromeDriver();
        //open URL
        driver.get("https://www.ilabquality.com/");
        //manage window
        driver.manage().window().maximize();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Window ID: " + driver.getWindowHandle());
        System.out.println("----------------------------------------------");

        driver.switchTo().newWindow(WindowType.TAB);
        //Navigate to Amazon
        driver.navigate().to("https://www.amazon.com/");

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Window ID: " + driver.getWindowHandle());

        //driver.navigate().back();
        //driver.navigate().forward();
    }
}
