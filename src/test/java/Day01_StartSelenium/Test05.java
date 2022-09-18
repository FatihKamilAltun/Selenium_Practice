package Day01_StartSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        // oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.navigate().to("https://facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title test is PASSED");
        } else System.out.println(actualTitle);

        // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        // yazdirin.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if (actualTitle.contains(expectedUrl)){
            System.out.println("URL test is PASSED");
        } else System.out.println(actualUrl);

        // https://www.walmart.com/ sayfasina gidin.
        Thread.sleep(3000);
        driver.navigate().to("https://walmart.com");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle2=driver.getTitle();
        String expectedTitle2="Walmart.com";
        if (actualTitle2.contains(expectedTitle2)){
            System.out.println("Title2 test is PASSED");
        } else System.out.println("Title2 test is FAILED");

        // Tekrar “facebook” sayfasina donun
        Thread.sleep(3000);
        driver.navigate().back();


        // Sayfayi yenileyin
        Thread.sleep(3000);
        driver.navigate().refresh();


        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // Browser’i kapatin
        driver.close();

    }
}
