package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
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
        //driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        String arananKelime="amazon";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(arananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
         driver.switchTo().newWindow(WindowType.WINDOW);
         driver.get("https://www.bestbuy.com");
        // 4- title'in Best Buy icerdigini test edelim

        // 5- ilk sayfaya donup sayfada java aratalim

        // 6- arama sonuclarinin Java icerdigini test edelim


        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim

        // 8- logonun gorundugunu test edelim

      Thread.sleep(3000);

    }
}
