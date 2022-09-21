package day11_Actions;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindFilePath {


    /*
    Kendi localimizdeki bir dosyayı web'e aktarmak için veya bir web sayfasindan bir dosya indirdikten sonra indirme işleminin başarılı olup olmadığını gibi işlemleri
    test edebilmek için oncelikle yapmamiz gereken dosyanın localimizdeki yolunu bulmamız gerekir. Bunun için oncelikle System.getProperty() methodu ile "user.home" kullanılır
     */

    // Dosyanın localde var olup olmadığını test etme
    @Test
    public void test01(){
        String anaPath=System.getProperty("user.home"); // Dosyaya ulaşmak için başlangıç yolunu verir
        System.out.println(System.getProperty("user.home")); // Emin olmak için yazdırdık
        String sonrakiPath="\\Desktop\\KAMİL\\MASAUSTU\\sistem.txt"; // Başlangıç yolundan sonra dosyaya kadar olan yolu elimizle de yazıp bir String'e atayabiliriz

        String filePath=anaPath+sonrakiPath; // Baştan sona dosyanın localdeki yolunu bulduk
        System.out.println(filePath); // Emin olmak için yazdırdık
        Assert.assertTrue(Files.exists(Paths.get(filePath))); // Dosyanın localde var olup olmadığını test ettik
        System.out.println(Files.exists(Paths.get(filePath))); // Dosyanın var olup olmadığını test ederek sonucu görmek için sonucu boolean veri tipinde yazdırdık
    }


}
