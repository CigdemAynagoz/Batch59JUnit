package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class CanhocaSoru2 extends TestBase {
    /*

1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
seçilir.
2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
txt dosyasına yazdırılır.
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.n11.com/");
        Assert.assertTrue("URL n11 içermiyor", driver.getCurrentUrl().contains("n11"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@id='myLocation-close-info'])")).click();
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        //I'm move to Magazalar
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//span[@title='Mağazalar'])"))).perform();

        //I select MagazalarıGör
        driver.findElement(By.xpath("(//a[@title='Mağazaları Gör'])")).click();
        Assert.assertTrue("Mağazalar sayfasina yönlendirilemedi",driver.getCurrentUrl().contains("https://www.n11.com/magazalar"));

        //I click the Tüm Magazalar button.
        driver.findElement(By.xpath("(//div[@class='tabList'])//ul//li[4]//div//h3")).click();
        String tumMgazalarTitle=driver.findElement(By.xpath("(//div[@id='contentSellerList']/div/div[2]/div/div[2]/div[4]/h2)")).getText();
        String AileBas=driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//span//i")).getText();
        Assert.assertTrue("Tüm Magazalar Title görüntülenemedi",tumMgazalarTitle.contains("Tüm Mağazalar"));
        Assert.assertTrue("Aile baslayan Magazalar Görüntülenemedi",AileBas.contains("A"));

        //I print the Tüm Magazalar in the letter A.
        List<WebElement> magaza = driver.findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//ul"));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")));

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("SeleniumStudy .txt"), "utf-8"));
            writer.write("N11 A ile başlayan Mağazalar : " + driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")).getText());

        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }


    }
}
