package day05_HelloMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AutomationExercise01MavenIle {

    WebDriver driver;
    Actions actions;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method01() throws InterruptedException {
        actions = new Actions(driver);
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String homePage = driver.findElement(By.xpath("//a[@style='color: orange;']")).getText();
        System.out.println("You are at " + homePage + " page");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignupVerify = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUserSignupVerify.isDisplayed()) {
            System.out.println("'New User Signup!' verify test is PASSED");
        } else System.out.println("'New User Signup!' verify test is FAILED");

        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Kamil Altun");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("denemeler3@gmail.com");
        Thread.sleep(1500);

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();


        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement verify1 = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        String verifyEnterAccountInformation = "ENTER ACCOUNT INFORMATION";
        if ((verify1.getText()).contains(verifyEnterAccountInformation)) {
            System.out.println("ENTER ACCOUNT INFORMATION test is PASSED");
        } else System.out.println("ENTER ACCOUNT INFORMATION test is FAILED");

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.cssSelector("#id_gender1")).click();
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        actions.click(passwordBox).sendKeys("123456" + Keys.TAB)
                .sendKeys("28" + Keys.TAB)
                .sendKeys("March" + Keys.TAB)
                .sendKeys("1996")
                .perform();

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first_name']"));
        actions.click(firstNameBox).sendKeys("Fatih Kamil" + Keys.TAB)
                .sendKeys("ALTUN" + Keys.TAB)
                .sendKeys("Hukuk Bürosu" + Keys.TAB)
                .sendKeys("Toparlar Mahallesi" + Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Israel" + Keys.TAB)
                .sendKeys("Anatolia" + Keys.TAB)
                .sendKeys("Antalya" + Keys.TAB)
                .sendKeys("07030" + Keys.TAB)
                .sendKeys("555-55-33" + Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // 13. Click 'Create Account button'


        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement actualAccountCreatedText = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (actualAccountCreatedText.isDisplayed()){
            System.out.println("'ACCOUNT CREATED!' test is PASSED");
        } else System.out.println("'ACCOUNT CREATED!' test is FAILED");

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        // 16. Verify that 'Logged in as username' is visible
        WebElement actualLoggedAsUsernameText=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (actualLoggedAsUsernameText.isDisplayed()){
            System.out.println("'Logged in as username' test is PASSED");
        } else System.out.println("'Logged in as username' test is FAILED");

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
