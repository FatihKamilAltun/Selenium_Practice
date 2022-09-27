package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise22 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Scroll to bottom of page
        WebElement allRightsText=driver.findElement(By.xpath("//*[text()='Copyright © 2021 All rights reserved']"));
        actions.scrollToElement(allRightsText).perform();

        // 4. Verify 'RECOMMENDED ITEMS' are visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='recommended items']")).isDisplayed());

        // 5. Click on 'Add To Cart' on Recommended product
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[69]")).click();

        // 6. Click on 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        // 7. Verify that product is displayed in cart page
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-1']")).isDisplayed());
    }
}
