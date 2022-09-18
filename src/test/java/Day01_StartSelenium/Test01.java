package Day01_StartSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");
        // Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        // Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedWord="Amazon";
        if (actualTitle.contains(expectedWord)){
            System.out.println("Title test is PASSED");
        } else System.out.println("Title test is FAILED");
        // Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        // Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL test is PASSED");
        } else System.out.println("URL test is FAILED");
        // Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        // Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String actualSources=driver.getPageSource();
        String expectedSource="Gateway";
        if (actualSources.contains(expectedSource)){
            System.out.println("Source test is PASSED");
        }else System.out.println("Source test is FAILED");
        // Sayfayi kapatin.
        driver.close();


    }
}
