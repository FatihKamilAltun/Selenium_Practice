package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel01 {
    @Test
    public void test01() throws IOException {

        // 7. Dosya yolunu bir String degiskene atayalim
        String filePath="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);
        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
        // 12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
        // 13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);

        // 3. Indexteki satirin 3. indexteki datanın "Cezayir" oldugunu test edin
        String expectedData="Cezayir";
        String actulaData=cell.toString();

        Assert.assertEquals(expectedData,actulaData);
        Assert.assertEquals(expectedData,cell.getStringCellValue()); // sağdaki, cell'in degerini string olarak donduruyor


    }
}
