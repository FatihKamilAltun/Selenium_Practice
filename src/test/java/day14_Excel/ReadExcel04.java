package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel04 {
    @Test
    public void test01() throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // ingilizce baskentler sutununu yazdiralim
        int lastRow = workbook.getSheet("Sayfa1").getLastRowNum();
        String satirdakiData = "";

        for (int i = 0; i <= lastRow; i++) {
            satirdakiData = ReadExcel03.banaDataGetir(i, 1);
            System.out.println(satirdakiData);
        }

    }
}
