package Day01_StartSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test06 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        // (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://youtube.com");
        String actualTitle1=driver.getTitle();
        String expectedTitle1="youtube";
        if (actualTitle1.contains(expectedTitle1)){
            System.out.println("Title1 test is PASSED");
        } else System.out.println(actualTitle1);

        // Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        // URL'yi yazdırın.
        String actualUrl1=driver.getCurrentUrl();
        String expectedUrl1="youtube";
        if (actualUrl1.contains(expectedUrl1)){
            System.out.println("Url1 test is PASSED");
        } else System.out.println(actualUrl1);

        // Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://amazon.com");

        // Youtube sayfasina geri donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Amazon sayfasina donun
        driver.navigate().forward();

        // Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        // Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        // doğru başlığı(Actual Title) yazdırın.
        String actualTitle2=driver.getTitle();
        String expectedTitle2="Amazon";
        if (actualTitle1.contains(expectedTitle1)){
            System.out.println("Title2 test is PASSED");
        } else System.out.println(actualTitle2);

        // Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        // URL'yi yazdırın
        String actualUrl2=driver.getCurrentUrl();
        String expectedUrl2="https://www.amazon.com";
        if (actualUrl1.contains(expectedUrl1)){
            System.out.println("Url1 test is PASSED");
        } else System.out.println(actualUrl2);

        // Sayfayi kapatin
        driver.close();

    }
}
