package day04_AutomationExerciseCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DersOdev01 {

            /*
            1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
            2- Add Element butonuna 10 kez basinız
            3- 10 kez Add element butonuna basıldığını test ediniz
            4- Delete butonuna görünmeyene kadar basınız
            5- Delete butonunun görünmediğini test ediniz
            6- Sayfayı kapatınız
            */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna 10 kez basinız
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']")); // TEXT KULLANIMINDA @ KOYMUYORUZ!!!!!!!!
        int count1 = 0;
        while (count1 < 10) {
            addButton.click();
            count1++;
        }

        // 3- 10 kez Add element butonuna basıldığını test ediniz

        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        String deleteButtonText = deleteButton.getText();

        List<WebElement> deleteButtonSize = driver.findElements(By.xpath("//*[text()='Delete']"));
        if (deleteButtonSize.size() == 10) {
            System.out.println(deleteButtonSize.size() + " kez delete butonuna basildi");
        } else System.out.println("Yeteri kadar delete butona basılmadı");


        //  4 - Delete butonuna görünmeyene kadar basınız
        for (int i = 0; i < deleteButtonSize.size(); i++) {
            deleteButtonSize.get(i).click();
        }


        // 5- Delete butonunun görünmediğini test ediniz

        try {
            if (deleteButton.isDisplayed()){
                System.out.println("FAILED");
            } else System.out.println("PASSED");
        } catch (Exception e){
            System.out.println("There is no more 'Delete' button");
        }



        // 6- Sayfayı kapatınız
        driver.close();


    }


}
