package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;

public class ReadExcel05 {
    @Test
    public void test01() throws IOException {

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // Ulkeler excel'indeki Sayfa2'ye gidip satir sayisinin 25, kullanilan satir sayisinin oldugnu test edin
        int lastRowIndex=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedRowNum=25;
        Assert.assertEquals(expectedRowNum,lastRowIndex+1);


        int kullanilanSatirSayisi=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        int expectedKullanilanSatirSayisi=15;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);
    }
}
