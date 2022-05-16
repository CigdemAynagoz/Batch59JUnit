package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    //amazona gidip dropdown dan books secenegini secip java aratalım
    //ve arama sonuclarının java icerdigini test edelim
    WebDriver driver;
    @Before
    public void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");

        //dropdown dan bir option secmek ııcn 3 adım vardr
        //1.ci adım dropdown ı locate edelim

        WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //'.ci adım select obj olusturup

        Select select=new Select(dropdownMenu);


        //3.adım dropdown da var olan optionlardan istedigimiz bir taneyi secelim
        select.selectByVisibleText("Books");
        //select.deselectByIndex();
        //select.deselectByValue();

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYasizi=sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYasizi.contains(arananKelime));
        Thread.sleep(3000);

    }
}
