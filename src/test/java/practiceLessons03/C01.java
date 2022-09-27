package practiceLessons03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm hayvan emojilerine tıklayın


        List<WebElement> emojiList=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        /*for (int i = 0; i < emojiList.size() ; i++) {
            actions.click(emojiList.get(i)).perform();
        }*/

        emojiList.forEach(t->t.click());

        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        /*WebElement textBox=driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]"));
        actions.click(textBox).sendKeys(faker.funnyName().toString()+Keys.TAB)
                .sendKeys(faker.name().firstName()+Keys.TAB)
                .sendKeys(faker.address().city()+Keys.TAB)
                .sendKeys(faker.food().vegetable()+Keys.TAB)
                .sendKeys(faker.food().dish()+Keys.TAB)
                .sendKeys(faker.address().state()+Keys.TAB)
                .sendKeys(faker.name().fullName()+Keys.TAB)
                .sendKeys(faker.address().buildingNumber())
                .sendKeys(faker.country().flag()+Keys.TAB)
                .sendKeys(faker.slackEmoji().toString()+Keys.TAB)
                .sendKeys(faker.address().zipCode()+Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(faker.name().lastName())
                .perform();*/

        List<WebElement> textBoxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String > text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelementi","boxes","listesine","kolayca","koyabilir","miyim"));

        for (int i = 0; i <textBoxes.size() ; i++) {
            textBoxes.get(i).sendKeys(text.get(i));
        }


        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}
