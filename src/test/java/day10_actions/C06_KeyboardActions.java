package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gidin
        driver.get("https://www.facebook.com");
        //yeni kayıt olustur a basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //isim kutusunu locate edip geriye kalan alanları TAB ile dolasarak formu doldurun
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions= new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("Cgdm").
                sendKeys(Keys.TAB).
                sendKeys("Grbz").
                sendKeys(Keys.TAB).
                sendKeys("c.grbz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("c.grbz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456789").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("1").
                sendKeys(Keys.TAB).
                sendKeys("Ocak").
                sendKeys(Keys.TAB).
                sendKeys("1991").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(10000);

    }
}
