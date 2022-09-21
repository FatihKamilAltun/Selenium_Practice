package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseAfterBefore;

public class AutomationExercise10 extends TestBaseAfterBefore {
    @Test
    public void test01() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Scroll down to footer
        WebElement footer=driver.findElement(By.xpath("//footer[@id='footer']"));
        actions.scrollToElement(footer).perform();

        // 5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());

        // 6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();

        // 7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']")).isDisplayed());
    }
}
