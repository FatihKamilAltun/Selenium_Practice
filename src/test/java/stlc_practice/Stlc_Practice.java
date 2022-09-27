package stlc_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Stlc_Practice extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // Kullanıcı "https://automationexercise.com" sayfasına gider
        driver.get("http://automationexercise.com");

        // Kullanıcı 'Signup / Login' butonuna tıklar
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // Kullanıcı verilen bilgiler ile sisteme giriş yapar
            // email:denemeler3@gmail.com
            // password:123465
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("denemeler3@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // Kullanıcı anasayfadaki ürünlerden sepetine ekler (2 adet ürün ekler)
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        WebElement firstProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[2]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(500);

        WebElement secondProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(secondProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[4]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(500);

        // Kullanıcı 'Cart'a gider
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // Kullanıcı sepetteki ürünleri doğrular
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-7']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-42']")).isDisplayed());

        // Kullanıcı sepetteki ürünleri satın almadan 'Logout' butonuna tıklayarak çıkış yapar
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();
    }
}
