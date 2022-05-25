package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //amazona gidip nutella aratalım ve sonuc sayısının oldugu webelementin fotografını cekelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File sonucYaziSS=new File("target/ekranResmi/amazonSonucYazisiSS.png");
        File temp=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziSS);
    }
}
