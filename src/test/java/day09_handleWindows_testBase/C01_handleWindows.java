package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;
    @Before
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
         driver.quit();
    }
    @Test
    public void test01(){
        //1-amazon anasayfaya gidin

        driver.get("https://amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        /*
        CDwindow-0A8AEF18DFABDCDBE375732C0F13671B
        bu kod acılan sayfanın unique hash kodudur.
        Selenıum sayfalar arası gecişte bu window handle degerini kullanır
        Eger sayfalar arasında driver imizi gezdiriryorsak ve herhangi bir sayfadan
         suanda bulundugumuz sayfaya gecmek istiyorsak
         driver.switchTo().window("CDwindow-0A8AEF18DFABDCDBE375732C0F13671B\n");
         bu sayfanın window handle degerini girerek bu sayfaya gecişi saglayabiliriz
        */

        //2-nutella ıcın arama yaptırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        //3-ilk urunun resmini tıklayarak farklı bir tab olarak acın
        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        //bu komutu kullngmzda driver oto olarak yeni tab a gecer
        //yeni tab da görevi gerceklestirmemiz icin adımları bastan almamız lazım
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();


        //4-yeni tab da acılan urunun title ini yazdırın
        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());

        //ilk sayfaya gecip url i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
}
