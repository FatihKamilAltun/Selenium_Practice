package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel02 {
    @Test
    public void test01() throws IOException {
        // 1. apache poi dependency’i pom file’a ekleyelim
        // 2. Java klasoru altinda resources klasoru olusturalim
        // 3. Excel dosyamizi resources klasorune ekleyelim
        // 4. excelAutomation isminde bir package olusturalim
        // 5. ReadExcel isminde bir class olusturalim
        // 6. readExcel() method olusturalim
        // 7. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)
        // 12. Row objesi olusturun sheet.getRow(index)
        // 13. Cell objesi olusturun row.getCell(index)
        String actualData = workbook.
                getSheet("Sayfa1").
                getRow(3).
                getCell(3).
                toString();
    }
}
