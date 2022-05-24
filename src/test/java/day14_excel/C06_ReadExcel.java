package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasındaki tum verileri claasımıza alıp bir java objesine store edelim.
        //böylece her seferinde excele ulasıp satır sutun vs ugrasmayalım

        //database yapısında olan excel i koyabilecegımız en uygun java objesi map'tir.

        Map<String,String> ulkelerMap=new HashMap<>();

        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <sonSatirIndex ; i++) {
            //Key i.ci satırdaki 0 indexsindeki datadır
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i.ci satırdaki 1,2, ve 3 indexdeki datalardır
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
            System.out.println(key+" , "+value);

        }
        System.out.println(ulkelerMap);

        //listede Ghana oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));

    }
}
