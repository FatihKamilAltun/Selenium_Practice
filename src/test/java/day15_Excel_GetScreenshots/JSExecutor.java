package day15_Excel_GetScreenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {

        // amazon sayfasina gidelim
        driver.get("https://amazon.com");

        // sayfanin altindaki 'sign in' butonu gorununceye kadar js ile scroll yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        Thread.sleep(3000);

        // 'Sign in' butonuna tiklayalim
        jse.executeScript("arguments[0].click();",signInButonu);
    }
}
