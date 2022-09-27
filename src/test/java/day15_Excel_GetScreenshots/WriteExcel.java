package day15_Excel_GetScreenshots;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test01() throws IOException {
        // 1)Yeni bir Class olusturalim WriteExcel
        // 2) Yeni bir test method olusturalim writeExcelTest()
        // 3) Adimlari takip ederek 1.satira kadar gidelim
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);

        // 4) 5.hucreye yeni bir cell olusturalim
        // 5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4).setCellValue("Nüfus");

        // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(4)
                .setCellValue(1500000);

        // 7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(9)
                .createCell(4)
                .setCellValue(250000);

        // 8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .createCell(4)
                .setCellValue(540000);

        // 9)Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);

        // 10)Dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();


    }
}
