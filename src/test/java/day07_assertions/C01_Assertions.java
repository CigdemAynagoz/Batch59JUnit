package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
   static WebDriver driver;

    @BeforeClass
    public static void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }
    @Test
    public void test01(){
        //amazon anasayfaya gidin
        //uc farkli test methodu olusturarak asagidaki gorevleri yapin
        //1- URL'in amazon icerdigini test edin
        String arananKelime="amazon";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(arananKelime));
    }
    @Test
    public void test02(){
        //2- title'in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actuelTitle=driver.getTitle();
        Assert.assertFalse(actuelTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        //3- sol ust kosede amazon logosunun gorundugunu test edin
     WebElement logoElement = driver.findElement(By.id("nav-logo-sprites"));
     Assert.assertTrue(logoElement.isDisplayed());
    }
}
