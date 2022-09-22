package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise17 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Add products to cart
        WebElement greenProduct = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[8]"));
        actions.scrollToElement(greenProduct).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN).perform();
        Thread.sleep(1500);
        actions.moveToElement(greenProduct).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[16]")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        // 5. Click 'Cart' button
        actions.scrollToElement(driver.findElement(By.xpath("//*[text()=' Cart']"))).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed());

        // 7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
        Thread.sleep(1500);

        // 8. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Cart is empty!']")).isDisplayed());
    }
}
