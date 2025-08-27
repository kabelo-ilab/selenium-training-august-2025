package Chapter4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateWebElements {
    public static void main(String[] args) {

        //locateById();
        //locateByName();
        //locateByLinkText();
        //locateByPartialLinkText();
        //locateByAbsXpath();
        locateByRelXPath();
    }

    static void locateByRelXPath(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement linkPassword = driver.findElement(By.xpath("//a[@href=\"/forgot_password\"]"));
        linkPassword.click();
    }

    static void locateByAbsXpath(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement linkDynamic = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[12]/a"));
        linkDynamic.click();

    }

    static void locateByPartialLinkText(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        WebElement linkTitle = driver.findElement(By.partialLinkText("Tutorial"));
        linkTitle.click();
    }

    static void locateByLinkText(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        WebElement linkTitle = driver.findElement(By.linkText("Selenium Tutorial"));
        linkTitle.click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://the-internet.herokuapp.com/");

        WebElement linkFormAuth = driver.findElement(By.linkText("Form Authentication"));
        linkFormAuth.click();
    }

    static void locateByName(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        WebElement txtMobile = driver.findElement(By.name("mobile"));
        txtMobile.sendKeys("0823456789");
    }

    static void locateById(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        //find elements
        WebElement txtFirstname = driver.findElement(By.id("name"));
        txtFirstname.sendKeys("Kabelo");

        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.sendKeys("kabelo@gmail.com");

    }
}
