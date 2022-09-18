package Day01_StartSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://youtube.com");
        // Amazon soyfasina gidelim. https://www.amazon.com/
        Thread.sleep(3000);
        driver.navigate().to("https://amazon.com");
        // Tekrar YouTube’sayfasina donelim
        Thread.sleep(3000);
        driver.navigate().back();
        // Yeniden Amazon sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward();
        // Sayfayi Refresh(yenile) yapalim
        Thread.sleep(3000);
        driver.navigate().refresh();
        // Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();

    }
}
