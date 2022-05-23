package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

    /*
    Test

1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin

2.“Our Products” butonuna basin
3.“Cameras product”i tiklayin
4.Popup mesajini yazdirin
5.“close” butonuna basin
6."WebdriverUniversity.com (IFrame)" linkini tiklayin
7."http://webdriveruniversity.com/index.html" adresine gittigini test edin*/

        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();

        //2.“Our Products” butonuna basin
     WebElement iframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
     driver.switchTo().frame(iframe);
     Thread.sleep(3000);
     driver.findElement(By.xpath("//a[text()='Our Products']")).click();

     //3.“Cameras product”i tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@id='camera-img']")).click();

     //4.Popup mesajini yazdirin
        String popupYazisi=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println("popupYazisi = " + popupYazisi);

        //5.“close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();


        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl ="http://webdriveruniversity.com/index.html";
        String actuelUrl= driver.getCurrentUrl();
        Assert.assertTrue(expectedUrl.equals(actuelUrl));




    }
}