package Day03_A101TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class A_101TestCase {

    /*

    Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.

    Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak zorunlu.
    - Senaryoya üye kaydı oluşturmadan devam edilecek.
    - Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
    - Açılan ürünün siyah olduğu doğrulanır.
    - Sepete ekle butonuna tıklanır.
    - Sepeti Görüntüle butonuna tıklanır.
    - Sepeti Onayla butonuna tıklanır.
    - Üye olmadan devam et butonuna tıklanır.
    - Mail ekranı gelir.
    - Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
    - Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.

     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        // Kullanici a.101.com sayfasina gider
        driver.get("https://a101.com.tr");
        Thread.sleep(10000);

        // Coocies kabul edilir
        WebElement coocies = driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        coocies.click();
        Thread.sleep(3000);

        // Kullanici "Giyim&Aksesuar" bolumune tiklar
        driver.findElement(By.xpath("(//a[@title='GİYİM & AKSESUAR'])[1]")).click();
        Thread.sleep(3000);

        // Kullanici  "Kadın İç Giyim" bolumune tiklar
        driver.findElement(By.xpath("(//a[@class='js-filter-link '])[2]")).click();
        Thread.sleep(3000);

        // Kullanici  "Dizaltı Çorap" bolumune tiklar
        driver.findElement(By.xpath("(//a[@href='/giyim-aksesuar/dizalti-corap/'])[2]")).click();
        Thread.sleep(3000);

        // Kullanıcı açılan sayfada siyah olan urune tıklar
        driver.findElement(By.xpath("(//img[@class=' lazyloaded'])[1]")).click();
        Thread.sleep(3000);

        // Kullanıcı "Sepete Ekle" butonuna tıklar
        driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        Thread.sleep(3000);

        // Kullanici  "Sepeti Görüntüle" butonuna tiklar
        driver.findElement(By.xpath("//a[@class='go-to-shop']")).click();
        Thread.sleep(3000);

        // Kullanici  "Sepeti Onayla" butonuna tiklar
        driver.findElement(By.xpath("//a[@class='button green checkout-button block js-checkout-button']")).click();
        Thread.sleep(3000);

        // Kullanici  "Üye Olmadan Devam Et" butonuna tiklar
        driver.findElement(By.xpath("//a[@class='auth__form__proceed js-proceed-to-checkout-btn']")).click();
        Thread.sleep(3000);

        // Kullanıcı mail adresini girer
        driver.findElement(By.xpath("(//input[@class='js-form-input'])[2]")).sendKeys("sacmala1234@gmail.com" + Keys.ENTER);

        // Kullanıcı "Yeni adres oluştur" butonuna tıklar
        driver.findElement(By.xpath("(//a[@class='new-address js-new-address'])[1]")).click();

        // Kullanıcı "Adres Başlığı" bilgilerini girer
        WebElement adresBasligi = driver.findElement(By.xpath("//input[@placeholder='Ev adresim, iş adresim vb.']"));
        actions.click(adresBasligi).sendKeys("Evim").sendKeys(Keys.TAB)
                .sendKeys("Fatih Kamil").sendKeys(Keys.TAB)
                .sendKeys("Altun").perform();

        // Kullanıcı telefon numarası bilgisini girer
        driver.findElement(By.xpath("//input[@class='js-phone-number']")).sendKeys("05011234758");

        // Kullanıcı il seçer
        driver.findElement(By.xpath("//select[@class='js-cities']")).sendKeys("ANTALYA");
        Thread.sleep(3000);

        // Kullanıcı ilçe seçer
        driver.findElement(By.xpath("//select[@class='js-township']")).sendKeys("KEPEZ");
        Thread.sleep(3000);

        // Kullanıcı mahalle seçer
        driver.findElement(By.xpath("//select[@class='js-district']")).sendKeys("KEMER MAH");
        Thread.sleep(3000);

        // Kullanıcı adres bilgilerini girer
        driver.findElement(By.xpath("//textarea[@class='js-address-textarea']")).sendKeys("38.Cadde 1235.Sokak No:3/4 Denemeler Apartmanı");
        Thread.sleep(3000);

        // Kullanıcı posta kodunu girer
        driver.findElement(By.xpath("//input[@class='js-post-code']")).sendKeys("07030");

        // Kullanıcı "Kaydet" butonuna tıklar
        driver.findElement(By.xpath("//button[@class='button green js-set-country js-prevent-emoji']")).click();














                /*.sendKeys("05437709118").sendKeys(Keys.TAB)
                .sendKeys("ANTALYA").sendKeys(Keys.TAB)
                .sendKeys("KEPEZ").sendKeys(Keys.TAB)
                .sendKeys("KEPEZ MAH").sendKeys(Keys.TAB)
                .sendKeys("Ev adresi ").sendKeys(Keys.TAB)
                .sendKeys("07030").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();*/

    }
}
