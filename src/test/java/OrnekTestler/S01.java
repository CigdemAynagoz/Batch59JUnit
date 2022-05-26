package OrnekTestler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class S01 extends TestBase {
    /*
    1) https://www.selenium.dev/downloads/ adresine gidelim
2) Selenium Client & WebDriver Language Bindings altinda Java driver'ini download edin
3) Browsers altinda Chrome documentation linkini tiklayalim
Chrome'un kendi sayfasina gidip Current stable release'i tiklayip size uygun olani download edin
*** buradaki surum ile bilgisayarinizdaki Chrome surumunun ayni oldugundan emin olun
4) src altinda resources director’si olusturun
5) Bu klasor altinda drivers ve libraries klasorleri olusturun
6) Indirdigimiz chromedriver'i drivers klasorune, selenium-java dosyasini ise libraries
klasorune cikartalim
7) intelliJ 'de yeni project / package / class olusturalim ve class icinde main method olusturalim
8) File/Project Structure/Modules/Dependencies kismindan jar dosyalarini yukleyelim

     */

    @Test
    public void test01() {
        //  1) https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();

        //2) Selenium Client & WebDriver Language Bindings altinda Java driver'ini download edin
        driver.findElement(By.xpath("//*[text()='4.1.4 (April 27, 2022)']")).click();

        //3) Browsers altinda Chrome documentation linkini tiklayalim
        driver.findElement(By.xpath("(//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]")).click();
        driver.findElement(By.xpath("(//a[text()='documentation'])[5]")).click();

        //Chrome'un kendi sayfasina gidip Current stable release'i tiklayip size uygun olani download edin
        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[2]")).click();

        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaWindowHandleDegeri="";

        for (String each:windowHandleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        driver.findElement(By.xpath("//a[@href='/101.0.4951.41/chromedriver_win32.zip']")).click();

        //*** buradaki surum ile bilgisayarinizdaki Chrome surumunun ayni oldugundan emin olun
        //4) src altinda resources director’si olusturun
        //5) Bu klasor altinda drivers ve libraries klasorleri olusturun
        //6) Indirdigimiz chromedriver'i drivers klasorune, selenium-java dosyasini ise libraries
        //klasorune cikartalim
        //7) intelliJ 'de yeni project / package / class olusturalim ve class icinde main method olusturalim
        //8) File/Project Structure/Modules/Dependencies kismindan jar dosyalarini yukleyelim

    }
}
