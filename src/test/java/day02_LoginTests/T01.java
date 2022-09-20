package day02_LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // id locatoru ile
        driver.get("https://amazon.com");
        // driver.findElement(By.id("twotabsearchtextbox")); // bizi arama cubuguna goturur
        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bilgisayar"); // arama cubuguna bilgisayar yazdirir
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bilgisayar"+ Keys.ENTER); // arama cubuguna bilgisayar yazdirip ENTER tusuna basar




    }
}
