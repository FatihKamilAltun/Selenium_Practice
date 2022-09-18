package Day08_DropDown_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownAmazonTest01 {
    static WebDriver driver;
    static Select select;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // - Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        // olmadigini test edin
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select = new Select(dropDownMenu);
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        Assert.assertFalse(ddmList.size() == 45);
    }

    @Test
    public void test02() {
        // - Test 2
        // 1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");

        // 2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // 3. Bulunan sonuc sayisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] resultTextArr = resultText.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : " + resultTextArr[3]);

        // 4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(resultText.getText().contains("Java"));
    }
}
