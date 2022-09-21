package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class AutomationExercise12 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 5. Hover over first product and click 'Add to cart'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        WebElement firstProductWE=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProductWE).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[2]")).click();

        // 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        // 7. Hover over second product and click 'Add to cart'
        WebElement secondProductWE=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(secondProductWE).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[4]")).click();

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        // 9. Verify both products are added to Cart
        List<WebElement> productList=driver.findElements(By.xpath("//img[@alt='Product Image']"));
        System.out.println(productList.size());
        Assert.assertEquals(2, productList.size());

        // 10. Verify their prices, quantity and total price
        System.out.println("First products price is '"+driver.findElement(By.xpath("(//*[text()='Rs. 500'])[1]")).getText()+"'");
        System.out.println("First products quantity is '"+driver.findElement(By.xpath("(//button[@class='disabled'])[1]")).getText()+"'");
        System.out.println("First products total price is '"+driver.findElement(By.xpath("(//*[text()='Rs. 500'])[2]")).getText()+"'");

        System.out.println("Second products price is '"+driver.findElement(By.xpath("(//*[text()='Rs. 400'])[1]")).getText()+"'");
        System.out.println("Second products quantity is '"+driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).getText()+"'");
        System.out.println("Second total products price is '"+driver.findElement(By.xpath("(//*[text()='Rs. 400'])[2]")).getText()+"'");
    }
}
