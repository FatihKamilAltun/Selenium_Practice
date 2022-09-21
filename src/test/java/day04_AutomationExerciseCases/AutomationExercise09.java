package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseAfterBefore;

import java.util.List;

public class AutomationExercise09 extends TestBaseAfterBefore {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        // 6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("women");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        // 8. Verify all the products related to search are visible
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='product-overlay']"));
        Assert.assertFalse(list.isEmpty());
    }
}
