package day04_AutomationExerciseCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DersOdev02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.amazon.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4)Sayfayi “refresh” yapin
        5)Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        6)Gift Cards sekmesine basin
        7)Birthday butonuna basin
        8)Best Seller bolumunden ilk urunu tiklayin
        9- Gift card details’den 25 $’i secin
        10-Urun ucretinin 25$ oldugunu test edin
        0-Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        // 4- Sayfayi “refresh” yapin
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.manage().window().maximize();

        // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String pageTitle = driver.getTitle();
        String partialWord = "Spend less";
        if (pageTitle.contains(partialWord)) {
            System.out.println("Title test is PASSED");
        } else System.out.println("Title test is FAILED");

        // 6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//*[text()='Gift Cards'])[1]")).click();

        // 7- Birthday butonuna basin
        driver.findElement(By.xpath("//a[@aria-label='Birthday gift cards']")).click();

        // 8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        //10- Urun ucretinin 25$ oldugunu test edin
        WebElement productPrice = driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));
        String expectedPrice = "$25.00";
        String actualPrice = productPrice.getText();
        if (actualPrice.equals(expectedPrice)) {
            System.out.println("Urunun degeri " + productPrice.getText() + "'dir");
        } else System.out.println("Urunun degeri " + productPrice.getText() + " degildir");

        //11- Sayfayi kapatin
        driver.close();


    }
}
