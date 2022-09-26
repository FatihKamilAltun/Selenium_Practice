package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise19 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 4. Verify that Brands are visible on left side bar
        WebElement brandsBar=driver.findElement(By.xpath("//div[@class='brands_products']"));
        actions.scrollToElement(brandsBar);

        // 5. Click on any brand name
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Babyhug']")).click();

        // 6. Verify that user is navigated to brand page and brand products are displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brand - Babyhug Products']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed());

        // 7. On left side bar, click on any other brand link
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Kookie Kids']")).click();

        // 8. Verify that user is navigated to that brand page and can see products
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brand - Kookie Kids Products']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='features_items']")).isEnabled());
    }
}
