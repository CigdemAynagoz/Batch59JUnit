package day11_faker_file;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dummy.txt dosyasını indirelim
        WebElement dummyLinki=driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummyLinki.click();
        Thread.sleep(5000);

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya downloads a indirilecektir.bize downloadsın dosya yolu lazım

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }
}
