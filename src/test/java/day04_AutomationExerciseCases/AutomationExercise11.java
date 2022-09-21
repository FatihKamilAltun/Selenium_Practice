package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise11 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 5. Scroll down to footer
        WebElement footerWE = driver.findElement(By.xpath("//div[@class='footer-widget']"));
        actions.scrollToElement(footerWE).perform();

        // 6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());

        // 7. Enter email address in input and click arrow button
        WebElement emailBoxWE = driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        actions.sendKeys(emailBoxWE,faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).isDisplayed());

    }
}
