package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class S08 extends TestBase {
    /*
    1. Yeni bir class olusturun (TekrarTesti)
2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
URL'yi yazdırın.
4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
5. Youtube sayfasina geri donun
6. Sayfayi yenileyin
7. Amazon sayfasina donun
8. Sayfayi tamsayfa yapin
9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
doğru başlığı(Actual Title) yazdırın.
10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
URL'yi yazdırın
11.Sayfayi kapatin
     */

    @Test
    public void test01() {
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        System.out.println(actualTitle);

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actuelUrl=driver.getCurrentUrl();
        String expectedUrl="youtube";
        Assert.assertTrue(actuelUrl.contains(expectedUrl));
        System.out.println(actuelUrl);

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        //doğru başlığı(Actual Title) yazdırın.
        String actualTitleAmzn = driver.getTitle();
        String expectedTitleAmzn="Amazon";
        Assert.assertTrue(actualTitleAmzn.contains(expectedTitleAmzn));
        System.out.println(actualTitleAmzn);

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        String actuelUrlAmzn=driver.getCurrentUrl();
        String expectedUrlAmzn="https://www.amazon.com/";
        Assert.assertEquals(expectedUrlAmzn,actuelUrlAmzn);
        System.out.println(actuelUrlAmzn);
    }
}
