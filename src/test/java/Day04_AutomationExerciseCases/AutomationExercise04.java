package Day04_AutomationExerciseCases;

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

public class AutomationExercise04 {

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
    public void test01(){  // Test Case 4: Logout User

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());
        System.out.println(homePage.getText()+" page is visible");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginToAccountText=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginToAccountText.isDisplayed());
        System.out.println("'"+loginToAccountText.getText()+"' is visible");

        // 6. Enter correct email address and password
        // (Correct email: denemeler3@gmail.com and password: 123456)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("denemeler3@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement loggedAsText=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedAsText.isDisplayed());
        System.out.println("'"+loggedAsText.getText()+"' is visible");

        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();

        // 10. Verify that user is navigated to login page
        WebElement loginPage=driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        loginPage.isDisplayed();
        System.out.println("You are at '"+loginPage.getText()+"' page");
    }
}
