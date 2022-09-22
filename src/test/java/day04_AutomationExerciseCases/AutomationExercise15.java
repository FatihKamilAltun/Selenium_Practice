package day04_AutomationExerciseCases;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise15 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());

        // 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Fill all details in Signup and create account
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameBox).
                sendKeys(faker.name().fullName() + Keys.TAB).
                sendKeys(faker.internet().emailAddress() + Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(5000);

        WebElement idGender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(idGender).click().
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password() + Keys.TAB).
                sendKeys("15" + Keys.TAB).
                sendKeys("March" + Keys.TAB).
                sendKeys("1996" + Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName() + Keys.TAB).
                sendKeys(faker.name().lastName() + Keys.TAB).
                sendKeys(faker.company().name() + Keys.TAB).
                sendKeys(faker.address().fullAddress() + Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("India" + Keys.TAB).
                sendKeys(faker.address().state() + Keys.TAB).
                sendKeys(faker.address().city() + Keys.TAB).
                sendKeys(faker.address().zipCode() + Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber() + Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        // 7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        // 8. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[2]")).click();
        Thread.sleep(1500);
        WebElement continueShoppingButton = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        continueShoppingButton.click();

        // 9. Click 'Cart' button
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 10. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed());

        // 11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        // 12. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Address Details']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Total Amount']")).isDisplayed());

        // 13. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        Thread.sleep(1500);
        actions.click(driver.findElement(By.xpath("//textarea[@class='form-control']"))).
                sendKeys("Urunler cok pahali").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCardBox=driver.findElement(By.xpath("//input[@name='name_on_card']"));
        actions.click(nameOnCardBox).sendKeys(faker.name().fullName()+Keys.TAB).sendKeys(faker.finance().iban()+Keys.TAB).
                sendKeys(faker.number().digits(3)+Keys.TAB).
                sendKeys(faker.number().digits(1)+Keys.TAB).sendKeys(faker.number().digits(4)).perform();

        // 15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@data-qa='pay-button']")).click();

        // 16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed());

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        // 18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            // "The delete site is broken"
    }
}
