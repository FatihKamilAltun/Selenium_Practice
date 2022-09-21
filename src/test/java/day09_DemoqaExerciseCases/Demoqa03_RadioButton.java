package day09_DemoqaExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseAfterBefore;

public class Demoqa03_RadioButton extends TestBaseAfterBefore {
    @Test
    public void test01() throws InterruptedException {
        // "https://demoqa.com" sayfasina gidin
        driver.get("https://demoqa.com");

        // 'Elements' menusunu secin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).click();

        // 'Radio Button' menusunu secin
        driver.findElement(By.xpath("//*[text()='Radio Button']")).click();

        // Acilan sayfada 'No' butonunun erisilemedigini dogrulayin
        WebElement noButton = driver.findElement(By.xpath("//input[@class='custom-control-input disabled']"));
        Assert.assertFalse(noButton.isEnabled());
    }
}
