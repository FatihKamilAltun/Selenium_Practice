package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise13 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click 'View Product' for any product on home page
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//*[text()='View Product'])[5]")).click();

        // 5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());

        // 6. Increase quantity to 4
        WebElement quantityWE = driver.findElement(By.xpath("//input[@id='quantity']"));

        actions.moveToElement(quantityWE).click().perform();
        int count=1;
        while (count<=3){
            actions.sendKeys(Keys.ARROW_UP).perform();
            count++;
        }

        // WebElement afterIncreaseQuantityWE = driver.findElement(By.xpath("//input[@id='quantity']"));


        // 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        // 9. Verify that product is displayed in cart page with exact quantity
        WebElement viewCartQuantityWE = driver.findElement(By.xpath("//button[@class='disabled']"));
        String viewCartQuantityStr=viewCartQuantityWE.getText();
        int viewCartQuantity=Integer.parseInt(viewCartQuantityStr);

        Assert.assertEquals(count,viewCartQuantity);


    }
}
