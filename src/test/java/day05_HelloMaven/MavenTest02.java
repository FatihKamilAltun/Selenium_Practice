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

import java.time.Duration;

public class MavenTest02 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void method01() {
        //2- https://www.google.com/ adresine gidin
        driver.get("https://google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actulaTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actulaTitle.contains(expectedTitle)) {
            System.out.println("Title test is PASSED");
        } else System.out.println("Title test is FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella" + Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(resultText.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] resultTextArr = resultText.getText().split(" ");
        String numberOfResult = resultTextArr[1].replace(".","");

        int number=Integer.parseInt(numberOfResult);
        if (number>10000000){
            System.out.println("Gelen sonuclarin sayisi 10.000.000'dan fazladir");
        } else System.out.println("Gelen sonuclarin sayisi 10.000.000'dan azdir");


    }


}
