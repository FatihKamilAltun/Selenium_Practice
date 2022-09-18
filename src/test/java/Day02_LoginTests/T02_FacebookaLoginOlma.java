package Day02_LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T02_FacebookaLoginOlma {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Facebook'a login olalim

        driver.get("https://facebook.com");
        WebElement kullaniciAdi = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        kullaniciAdi.sendKeys("deneme1234@gmail.com");

        WebElement parola = driver.findElement(By.xpath("//input[@type='password']"));
        parola.sendKeys("password");

        WebElement girisButonu = driver.findElement(By.xpath("//button[@name='login']"));
        girisButonu.click();


    }
}
