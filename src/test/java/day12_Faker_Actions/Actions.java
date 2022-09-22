package day12_Faker_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // Yeni Class olusturun ActionsClassHomeWork
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirst).perform();
        Thread.sleep(3000);

        // 3 Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        Thread.sleep(3000);

        // 4 Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);

        // 5 Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        // 6 “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButton).perform();
        Thread.sleep(3000);

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());
        Thread.sleep(3000);

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(3000);
    }
}
