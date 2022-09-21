package day11_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class FacebookCreateAAccount extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //  1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //  2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //  3- Ad, soyad, mail ve sifre kutularina deger yazalim
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        String email = faker.internet().emailAddress();
        actions.click(nameBox)
                .sendKeys(faker.funnyName().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("25").sendKeys(Keys.TAB).
                sendKeys("Eyl").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();


        //  4- Kaydol tusuna basalim
    }
}
