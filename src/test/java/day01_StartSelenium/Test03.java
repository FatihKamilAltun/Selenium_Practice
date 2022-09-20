package day01_StartSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");
        // Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        // simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        // Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        // Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        // Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("fs : " + driver.manage().window().getPosition());
        System.out.println("fs : " + driver.manage().window().getSize());
        // Sayfayi kapatin
        driver.close();

    }
}
