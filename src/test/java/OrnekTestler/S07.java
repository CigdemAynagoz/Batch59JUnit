package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class S07 extends TestBase {
    /*
    1.Yeni bir class olusturalim (Homework)
2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
yazdirin.
4.https://www.walmart.com/ sayfasina gidin.
5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
6. Tekrar “facebook” sayfasina donun
7. Sayfayi yenileyin
8. Sayfayi tam sayfa (maximize) yapin
9.Browser’i kapatin
     */

    @Test
    public void test01() {
        //2.ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://www.facebook.com");

        // sayfa basliginin (title) “facebook” icermedigini dogrulayin (verify), degilse dogru basligi yazdirin.
        String expectedTitle="facebook";
        String actuelTitle=driver.getTitle();
        Assert.assertFalse(actuelTitle.contains(expectedTitle));
        System.out.println(actuelTitle);

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrl="facebook";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(expectedUrl));
        System.out.println(actuelUrl);

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitle2="Walmart.com";
        String actuelTitle2=driver.getTitle();
        Assert.assertTrue(actuelTitle2.contains(expectedTitle2));

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //7. Sayfayi yenileyin
        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
    }
}
