package day15_Excel_GetScreenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TumSayfaScreenshot extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        // Amazon sayfasina gidip tum sayfanin ekran goruntusunu alalim

        driver.get("https://amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY-MM-dd HH.mm.ss");
        String tarih = date.format(dtf);

        File tumSayfaResim = new File("target/screenshots/tumSayfa" + tarih + ".jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaResim);


    }
}
