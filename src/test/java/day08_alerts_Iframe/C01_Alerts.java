package day08_alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        /* Herhangi bir web sitesine gidince veya
   bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

   Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir.
   bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
   tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
   driver.get("https://www.facebook.com"); da cikan alert vb.

   Ancak e
   web uygulamalarında html alert yanında java script alerrt de kullanılır ve bunlar locate edilemez.
   selenıumda bunlar ıcın cok ozel bır yontem gelistrilmstr
 */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text='Click for JS Alert']")).click();

        //alert 'te OK tusuna basın
        driver.switchTo().alert().accept();

        //result kısmında "You successfully clicked an alert" yazısı cıktıgını test edin
        String expectedResult = "You successfully clicked an alert";
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actuelResult = sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResult,actuelResult);
    }
}
