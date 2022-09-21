package practiseLessons02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_KoalaHotel extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // Kullanici "https://www.koalaresorthotels.com/" sayfasina gider
        driver.get("https://www.koalaresorthotels.com/");

        // Login butonuna tiklar
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        // Login ekranina girdiğinizi 4 farkli webElementi kullanarak dogrulayiniz

        // 1-)
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Log"));

        // 2-)
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Log in"));

        // 3-)
        WebElement logInText01 = driver.findElement(By.xpath("//h1[text()='Log in']"));
        Assert.assertTrue(logInText01.getText().contains("Log in"));

        // 4-)
        WebElement logInText02 = driver.findElement(By.xpath("//h2[text()='Log in']"));
        Assert.assertTrue(logInText02.getText().contains("Log in"));
    }
}
