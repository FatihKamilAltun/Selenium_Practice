package day02_LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T03_AmazondakiLinkSayisiniBulma {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon.com'daki link sayisini bulalim
        driver.get("https://amazon.com");
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));
        System.out.println(linkListesi.size());
    }
}
