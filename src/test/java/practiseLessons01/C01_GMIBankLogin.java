package practiseLessons01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- 'https://www.gmibank.com/' adresine gidelim
        driver.get("https://www.gmibank.com/");

        // 2- Sign-in butonuna tiklayiniz
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();

        // 3- "Username: Batch81", "Password: Batch81+" bilgilerini kullanarak giris yapiniz
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Batch81+"+ Keys.ENTER);


        // driver.close();
    }
}
