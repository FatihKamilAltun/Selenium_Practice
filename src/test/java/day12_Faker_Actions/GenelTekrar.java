package day12_Faker_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.sql.DriverManager;
import java.util.List;


public class GenelTekrar extends TestBaseBeforeAfter {

    Select select;

    @Test
    public void test01() {
        //1- amazon gidin
        driver.get("https://amazon.com");

        //2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDown);
        List<WebElement> dropDownMenuList = select.getOptions();
        for (WebElement each: dropDownMenuList
             ) {
            System.out.println(each.getText());
        }

        //3 dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println(dropDownMenuList.size());
        Assert.assertNotEquals(40, dropDownMenuList.size());


    }

    @Test
    public void test02() {
        // Test02
        // 1 dropdown menuden elektronik bölümü seçin
        driver.get("https://amazon.com");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDown);
        select.selectByVisibleText("Electronics");

        // 2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);

        // 3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement resultTextWE=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultTextWE.getText().contains("iphone"));

        // 4 ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//img[@data-image-latency='s-product-image'])[5]")).click();

        // 5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement productTitleWE=driver.findElement(By.xpath("//span[@id='productTitle']"));

    }
}
