package Day04_AutomationExerciseCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class demoqa_TestBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com");

        driver.findElement(By.xpath("(//div[@class='card-up'])[1]")).click();

        driver.findElement(By.xpath("(//span[@class='text'])[1]")).click();

        driver.findElement(By.xpath("//input[@class=' mr-sm-2 form-control']")).sendKeys("Fatih Kamil ALTUN"+ Keys.TAB);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@class='mr-sm-2 form-control']")).sendKeys("deneme@gmail.com"+Keys.TAB);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Toparlar Mahallesi"+Keys.TAB);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Koycegiz Mugla");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();




    }
}
