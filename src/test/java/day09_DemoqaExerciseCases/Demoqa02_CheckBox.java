package day09_DemoqaExerciseCases;

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

public class Demoqa02_CheckBox {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01(){
        // Navigate to url 'https://demoqa.com'
        driver.get("https://demoqa.com");


        // Choose the 'Elements' menu
        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();

        // Choose the 'Elements' menu at left
        driver.findElement(By.xpath("//*[text()='Elements']")).click();

        // Click on 'Check Box' button
        driver.findElement(By.xpath("//*[text()='Check Box']")).click();

        // Click the "Home Toggle(>)" for open the submenu
        driver.findElement(By.xpath("//button[@aria-label='Toggle']")).click();

        // Click the "Documents Toggle" for open the submenu
        driver.findElement(By.xpath("(//button[@title='Toggle'])[3]")).click();

        // Click the "Office Toggle" for open the submenu
        driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[5]")).click();

        // Choose the "Classified"
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[8]")).click();

        // Verify 'You have selected : classified' text is visible and print
        WebElement resultText=driver.findElement(By.xpath("//div[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());
        System.out.println("'"+resultText.getText()+"' is visible");

        // Click the "Office Toggle" for close the menu
        driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[5]")).click();

        //Click the "Downloads Toggle" for open the submenu
        driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[6]")).click();
    }
}
