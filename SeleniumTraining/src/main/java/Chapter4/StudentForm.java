package Chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentForm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        //firstname
        WebElement txtFirstname = driver.findElement(By.id("name"));
        txtFirstname.sendKeys("John");
        System.out.println(txtFirstname.getText());
        //email
        driver.findElement(By.id("email")).sendKeys("john@gmail.com");
        //gender
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input")).click();
        //mobile
        driver.findElement(By.id("mobile")).sendKeys("0123456789");
        //dob
        driver.findElement(By.id("dob")).sendKeys("03-02-1998");
        //subject
        driver.findElement(By.id("subjects")).sendKeys("Java");
        //hobbies
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[7]/div/div/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[7]/div/div/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[7]/div/div/div[3]/input")).click();
        //address
        driver.findElement(By.xpath("//textarea[@id=\"picture\" and @placeholder=\"Currend Address\"]"))
                .sendKeys("123 Rivonia Road\nSandton, 2014");




    }
}
