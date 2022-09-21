package day11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseAfterBefore;

public class Actions extends TestBaseAfterBefore {

    @Test
    public void test01() {
        // Yeni bir class olusturalim: MouseActions3
        // 1 https://www.amazon.com/ adresine gidelim
        driver.get("https://amazon.com");

        // 2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        // mouse’u bu menunun ustune getirelim
        WebElement WE = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(WE).perform();

        // 3 “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        // 4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//li[@id='my-lists-tab']")).getText();
        String expectedText="Your Lists";
        Assert.assertEquals(expectedText,actualText);
    }
}
