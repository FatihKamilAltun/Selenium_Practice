package day04_AutomationExerciseCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise05 {

    WebDriver driver;

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
        System.out.println("'" + homePage.getText() + "' page is visible");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        System.out.println("'" + newUserSignup.getText() + "' is visible");

        // 6. Enter name and already registered email address
        // Already name is : Kamil
        // Already email is : denemeler3@gmail.com
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Kamil");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("denemeler3@gmail.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // 8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExistText=driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(alreadyExistText.isDisplayed());
        System.out.println("'"+alreadyExistText.getText()+"' is visible");
    }
}
