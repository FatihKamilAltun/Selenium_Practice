package Day06_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assert_Odev02 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        // 9. Sayfayi kapatin
        driver.close();
    }

    @Test
    public void method01() {
        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // 3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        // 4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String firstProductName = firstProduct.getText();
        firstProduct.click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String allText = driver.findElement(By.xpath("//html[@lang='en']")).getText();
        if (allText.contains(firstProductName)){
            System.out.println("Urun sepette");
        } else System.out.println("Urun sepette degil");




    }
}
