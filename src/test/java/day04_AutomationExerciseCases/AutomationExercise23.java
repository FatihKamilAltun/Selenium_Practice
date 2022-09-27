package day04_AutomationExerciseCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationExercise23 extends TestBaseBeforeAfter {
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
        WebElement nameBox=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameBox)
                .sendKeys(faker.name().fullName()+ Keys.TAB)
                .sendKeys(faker.internet().emailAddress()+Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        String adress=faker.address().fullAddress();

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        actions.click(passwordBox)
                .sendKeys(faker.internet().password()+Keys.TAB)
                .sendKeys("25"+Keys.TAB)
                .sendKeys("May"+Keys.TAB)
                .sendKeys("1990"+Keys.TAB)
                .tick()
                .sendKeys(Keys.TAB)
                .tick()
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName()+Keys.TAB)
                .sendKeys(faker.name().lastName()+Keys.TAB)
                .sendKeys(faker.company().name()+Keys.TAB)
                .sendKeys(adress+Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("India"+Keys.TAB)
                .sendKeys(faker.address().city()+Keys.TAB)
                .sendKeys(faker.address().state()+Keys.TAB)
                .sendKeys(faker.address().zipCode()+Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()+Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        // 7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        // 8. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);

        WebElement firstProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[2]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(500);

        WebElement secondProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(secondProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[4]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(500);

        WebElement thirdProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[3]"));
        actions.moveToElement(thirdProduct).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[text()='Add to cart'])[6]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        Thread.sleep(500);

        // 9. Click 'Cart' button
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        // 10. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed());

        // 11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        // 12. Verify that the delivery address is same address filled at the time registration of account
        Assert.assertEquals(driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]")).getText(),adress);

        // 13. Verify that the billing address is same address filled at the time registration of account
        Assert.assertEquals(driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]")).getText(),adress);

        // 14. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        // 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            // The site is broken
    }
}
