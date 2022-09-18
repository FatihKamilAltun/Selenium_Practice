package Day02_LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T05_AmazonSearchTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // web sayfasına gidin. https://www.amazon.com/
        driver.get("https://amazon.com");

        // Search(ara) “city bike”
        WebElement serachBox = driver.findElement(By.id("twotabsearchtextbox"));
        serachBox.sendKeys("city bike" + Keys.ENTER);

        // Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());

        // Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // En son sayfayi kapatiniz
        driver.close();

    }
}
