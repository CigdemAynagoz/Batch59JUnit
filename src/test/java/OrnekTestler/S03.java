package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class S03 extends TestBase {
    /*
    1. Yeni bir package olusturalim : day01
2. Yeni bir class olusturalim : C03_GetMethods
3. Amazon sayfasina gidelim. https://www.amazon.com/
4. Sayfa basligini(title) yazdirin
5. Sayfa basliginin “Amazon” icerdigini test edin
6. Sayfa adresini(url) yazdirin
7. Sayfa url’inin “amazon” icerdigini test edin.
8. Sayfa handle degerini yazdirin
9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
10. Sayfayi kapatin.
     */

    @Test
    public void test01() {
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        String sayfaBasligi=driver.getTitle();
        System.out.println("sayfaBasligi = " + sayfaBasligi);

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String actuelTitle=driver.getTitle();
        String istenenKelime="Amazon";
        Assert.assertTrue(actuelTitle.contains(istenenKelime));

        //6. Sayfa adresini(url) yazdirin
        String sayfaUrl=driver.getCurrentUrl();
        System.out.println("sayfaUrl = " + sayfaUrl);

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String actuelUrl=driver.getCurrentUrl();
        String arananKelime="amazon";
        Assert.assertTrue(actuelUrl.contains(arananKelime));

        //8. Sayfa handle degerini yazdirin
        String sayfaHD=driver.getWindowHandle();
        System.out.println("sayfaHD = " + sayfaHD);

        //9. Sayfa HTML kodlarinda “script” kelimesi gectigini test edin
        String syfaHtmlKod=driver.getPageSource();
        String arananVeri="script";
        Assert.assertTrue(syfaHtmlKod.contains(arananVeri));
    }
}
