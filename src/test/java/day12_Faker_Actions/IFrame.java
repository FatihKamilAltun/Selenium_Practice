package day12_Faker_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class IFrame extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // 1- Bir Class olusturalim KeyboardActions2
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        WebElement iframeWE=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        actions.scrollToElement(iframeWE).perform();

        // 4- videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(iframeWE);
        WebElement videoWE=driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        // 5- videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).isDisplayed());
    }
}
