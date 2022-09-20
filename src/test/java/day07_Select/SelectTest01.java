package day07_Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectTest01 {

    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method01() {
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        select=new Select(dropdown);
        // select.selectByVisibleText("Option 1");
        // select.selectByValue("1");
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //  4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list=select.getOptions();
        list.stream().forEach(t-> System.out.println(t.getText()));

        //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //  False yazdırın.
        System.out.println(list.size()==4?"true":"false");


    }

    @After
    public void tearDown() {
        driver.close();
    }
}
