package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel06 {
    @Test
    public void test01() throws IOException {

        // Ulkeler excel'indeki tum verileri classimiza alip
        // bir Java objesine store edelim
        // boylece her seferinde excel'e ulasip satir, sutun vs ugrasmayalim

        // maple yapaim bunun için bize key ve value lazım

        // database yapisinda olan exceli koyabileceğimiz en uygun Java objesi Map'tir

        Map<String, String> ulkelerMap = new HashMap<>();

        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        int lastRowIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= lastRowIndex; i++) {
            // key i. satirdaki 0 indexindeki data olacak
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i. satirdaki 1,2 ve 3. indexindeki datalarin birlesimi olacak
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key, value);
            System.out.println(key + "," + value);
        }
        System.out.println(ulkelerMap);

        // Listede 'Ghana' oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));


    }
}
