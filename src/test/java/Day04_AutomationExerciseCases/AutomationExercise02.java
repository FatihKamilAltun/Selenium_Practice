package Day04_AutomationExerciseCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise02 {

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
        // driver.close();
    }

    @Test
    public void test01() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed();
        System.out.println("Home page is visible");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountText = driver.findElement(By.xpath("(//h2)[1]"));
        loginToYourAccountText.isDisplayed();
        System.out.println(loginToYourAccountText.getText()+ " is visible");

        // 6. Enter correct email address and password (mail:denemeler3@gmail.com password:123456)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("denemeler3@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement loginAsUsernname = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        loginAsUsernname.isDisplayed();
        System.out.println(loginAsUsernname.getText());

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
                // Sayfada hata var
        driver.findElement(By.xpath("//h1")).isDisplayed();


    }
}
