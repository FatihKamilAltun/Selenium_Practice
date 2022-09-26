package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise18 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that categories are visible on left side bar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Category']")).isDisplayed());

        // 4. Click on 'Women' category
        driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[1]")).click();

        // 5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[text()='Tops ']")).click();

        // 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Women - Tops Products']")).isDisplayed());

        // 7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='Jeans ']")).click();

        // 8. Verify that user is navigated to that category page
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Men - Jeans Products']")).isDisplayed());
    }
}
