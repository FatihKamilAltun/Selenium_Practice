package day04_AutomationExerciseCases;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise06 {
    WebDriver driver;
    Faker faker;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());
        System.out.println(homePage.getText() + " page is visible");

        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchText = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouchText.isDisplayed());
        System.out.println("'" + getInTouchText.getText() + "' is visible");

        // 6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("About what");
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys("I'm writing this message for your sites 'Delete Button' is not working" + Keys.PAGE_DOWN);

        // 7. Upload file
        WebElement uploadButton = driver.findElement(By.xpath("//input[@name='upload_file']"));
        String filePath="C:\\Users\\FatihKamil\\Desktop\\Sikayet.txt";
        uploadButton.sendKeys(filePath);

        // 8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        // 9. Click OK button
        driver.switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement verifyText = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(verifyText.isDisplayed());
        System.out.println("'" + verifyText.getText() + "' is visible");

        // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());
        System.out.println("You are at " + driver.findElement(By.xpath("//*[text()=' Home']")).getText() + " page");


    }
}
