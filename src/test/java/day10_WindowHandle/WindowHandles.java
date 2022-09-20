package day10_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {


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

        // 1-Tests package'inda yeni bir class olusturun: WindowHandle2
        // 2-https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        // 3-Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.getText().contains("Opening a new window"));

        // 4-Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // 5-Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

                /*
                eger kontrolsuz acilan bit tab veya window varssa
                o zaman sayfalarin window handle degerlerini elde etmek gerekir
                oncelikle 2. sayfa acilmadan once ilk sayfanin window handle degerini bir String'e atayalim
                 */

                String ilkWindowHandleDegeri = driver.getWindowHandle();

                /*
                switchTo().newWindow() demeden link tıklayarak yeni tab veya window olustugunda
                biz driver'a yeni sayfaya gec demedikce, dr,ver eski sayfada kalir
                ve yeni sayfa ile ilgili hicbir islem yapamaz
                yeni sayfada driver'i calistirmak isterseniz
                once driver'i yeni sayfaya yollamamiz gerekir
                 */

                /*
                Yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir.
                Bunu icin driver.getWindowHandles() methodunu kullanarak
                acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.

                İlk sayfanin window handle degerini zaten biliyoruz
                Set'deki window handle degerlerini kontrol edip
                ilk sayfanin handle degerine esit olmayan ikinci sayfanin window handle degeridir deriz.

                 */

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri = "";
        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilkWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }

        // Artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasi gecisi yaoabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        // 6-Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle);

        // 7-Sayfadaki textin "New Window" olduğunu doğrulayın.
        WebElement ikinciSayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String actualIkinciYazi = ikinciSayfadakiYaziElementi.getText();
        String expectedıkinciYazi = "New Window";
        Assert.assertEquals(expectedıkinciYazi, actualIkinciYazi);

        // 8-Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        driver.switchTo().window(ilkWindowHandleDegeri);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}
