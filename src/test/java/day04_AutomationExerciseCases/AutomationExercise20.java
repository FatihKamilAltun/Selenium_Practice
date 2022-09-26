package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise20 extends TestBaseBeforeAfter{
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

        // 5. Enter product name in search input and click search button
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search_product']"));
        String searchWord="Women";
        actions.click(searchBox).sendKeys(searchWord).perform();
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

        // 6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed());

        // 7. Verify all the products related to search are visible
        String firstProductTitle=driver.findElement(By.xpath("(//*[text()='Madame Top For Women'])[1]")).getText();
        Assert.assertTrue(firstProductTitle.contains(searchWord));

        String secondProductTitle=driver.findElement(By.xpath("(//*[text()='Lace Top For Women'])[1]")).getText();
        Assert.assertTrue(secondProductTitle.contains(searchWord));
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 8. Add those products to cart
        Thread.sleep(500);
        WebElement firstProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));

        actions.moveToElement(firstProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[2]")).click();

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        WebElement secondProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(secondProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[4]")).click();

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        // 9. Click 'Cart' button and verify that products are visible in cart
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-7']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-42']")).isDisplayed());

        // 10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        WebElement emailBox=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actions.click(emailBox).sendKeys("denemeler3@gmail.com"+Keys.TAB).sendKeys("123456"+Keys.TAB+Keys.ENTER).perform();

        // 11. Again, go to Cart page
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 12. Verify that those products are visible in cart after login as well
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-7']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-42']")).isDisplayed());
    }
}
