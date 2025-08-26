package Chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownList {
    public static void main(String[] args) {

        //singleSelect();
        multiSelect();
    }

    static void multiSelect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://ironspider.ca/forms/dropdowns.htm");
        driver.manage().window().maximize();

        WebElement cmbCoffee = driver.findElement(By.cssSelector("select[name=\"coffee\"]"));
        Select coffeeMenu = new Select(cmbCoffee);
        coffeeMenu.selectByValue("regular");

        WebElement cmbCoffee2 = driver.findElement(By.xpath("//select[@name=\"coffee2\"]"));
        Select coffeeOptions = new Select(cmbCoffee2);
        coffeeOptions.selectByValue("cream");
        coffeeOptions.selectByValue("sugar");
        coffeeOptions.selectByValue("donut");
        coffeeOptions.selectByValue("muffin");
    }

    static void singleSelect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://ironspider.ca/forms/dropdowns.htm");
        driver.manage().window().maximize();

        WebElement cmbCoffee = driver.findElement(By.cssSelector("select[name=\"coffee\"]"));
        Select coffeeOptions = new Select(cmbCoffee);
        //select sugar
       // coffeeOptions.selectByIndex(2);
       // coffeeOptions.selectByValue("sugar");
        coffeeOptions.selectByVisibleText("With sugar");

//        List<WebElement> coffeeList = coffeeOptions.getOptions();
//
//        for (WebElement coffee: coffeeList){
//            System.out.println(coffee.getAttribute("value"));
//        }
    }
}
