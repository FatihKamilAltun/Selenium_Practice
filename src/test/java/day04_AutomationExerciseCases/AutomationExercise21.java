package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise21 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        // 3. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

        // 5. Click on 'View Product' button
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN).perform();
        WebElement viewProductButton = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        actions.moveToElement(viewProductButton).perform();
        Thread.sleep(1000);
        actions.click(viewProductButton).perform();

        // 6. Verify 'Write Your Review' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Write Your Review']")).isDisplayed());

        // 7. Enter name, email and review
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement yourNameBox = driver.findElement(By.xpath("//input[@id='name']"));
        actions.click(yourNameBox)
                .sendKeys(faker.name().firstName() + Keys.TAB)
                .sendKeys(faker.internet().emailAddress() + Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .perform();

        // 8. Click 'Submit' button
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='button-review']"));
        actions.scrollToElement(submitButton).click(submitButton).perform();

        // 9. Verify success message 'Thank you for your review.'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Thank you for your review.']")).isDisplayed());


    }
}
