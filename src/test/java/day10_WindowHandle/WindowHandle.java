package day10_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // 1- "https://amazon.com" sayfasina gidin
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        // 2- Basligin 'amazon' icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // 3- Yeni bir pencerede "https://bestbuy.com" sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();

        // 4- Basligin 'Best Buy' icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5- Ilk sayfaya gidip "Java" kelimesini aratin
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // 6- Arama sonuclarinin Java icerdigini test edin
        WebElement resultText=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultText.getText().contains("Java"));

        // 7- Yeniden bestbuy'in acik oldugu sayfaya gidin
        driver.switchTo().window(bestBuyWindowHandle);

        // 8- Logonun gorunur oldugunu test edin
        driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed();

    }

}
