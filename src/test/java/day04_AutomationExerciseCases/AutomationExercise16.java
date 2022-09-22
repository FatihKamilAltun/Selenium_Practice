package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise16 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Fill email, password and click 'Login' button
        WebElement eMailBox=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actions.click(eMailBox).sendKeys("denemeler3@gmail.com", Keys.TAB).
                sendKeys("123456",Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        // 6. Verify 'Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        // 7. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[2]")).click();
        Thread.sleep(1500);
        WebElement continueShoppingButton = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        continueShoppingButton.click();

        // 8. Click 'Cart' button
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed());

        // 10. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        // 11. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Total Amount']")).isDisplayed());


        // 12. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        Thread.sleep(1500);
        actions.click(driver.findElement(By.xpath("//textarea[@class='form-control']"))).
                sendKeys("Urunler cok pahali").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCardBox=driver.findElement(By.xpath("//input[@name='name_on_card']"));
        actions.click(nameOnCardBox).sendKeys(faker.name().fullName()+Keys.TAB).sendKeys(faker.finance().iban()+Keys.TAB).
                sendKeys(faker.number().digits(3)+Keys.TAB).
                sendKeys(faker.number().digits(1)+Keys.TAB).sendKeys(faker.number().digits(4)).perform();

        // 14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@data-qa='pay-button']")).click();

        // 15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed());

        // 16. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            // "The delete site is broken"
    }
}
