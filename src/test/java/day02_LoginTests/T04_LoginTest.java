package day02_LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T04_LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        // email textbox,password textbox, and signin button elementlerini locate ediniz..
        // Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // Username : testtechproed@gmail.com
        // Password : Test1234!
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        // Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement kullaniciAdi = driver.findElement(By.xpath("//span[@class='navbar-text']"));
        if (kullaniciAdi.isDisplayed()) {
            System.out.println("User id is true");
        } else System.out.println("User id is false");

        // “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adresses = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][1]"));
        if (adresses.isDisplayed()) {
            System.out.println("Adresses is displayed");
        } else System.out.println("Adresses is not displayed");

        WebElement signOutButton = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][2]"));
        if (signOutButton.isDisplayed()) {
            System.out.println("signOutButton is displayed");
        } else System.out.println("signOutButton is not displayed");

        // Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkSayisi = driver.findElements(By.tagName("a"));
        System.out.println("Sitede " + linkSayisi.size() + " adet link vardir");


    }
}
