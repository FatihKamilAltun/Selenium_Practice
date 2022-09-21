package day11_Actions;

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
        WebElement WE=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(WE).perform();

        // mouse’u bu menunun ustune getirelim
        // 3 “Create a list” butonuna basalim
        // 4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        // degisiklik
    }
}
