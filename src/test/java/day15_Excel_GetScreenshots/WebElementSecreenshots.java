package day15_Excel_GetScreenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class WebElementSecreenshots extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        // Amazon sayfasina gidip 'Nutella' aratalim
        // ve sonuc sayisinin oldugu web elementinin fotografini cekelim

        driver.get("https://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        WebElement resultText=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File resultWESS=new File("target//screenshots/resultTextSS.jpeg");
        File temp=resultText.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,resultWESS);
    }
}
