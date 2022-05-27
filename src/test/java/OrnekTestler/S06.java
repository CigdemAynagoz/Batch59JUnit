package OrnekTestler;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class S06 extends TestBase {
    /*
    1. Yeni bir Class olusturalim.C07_ManageWindowSet
2. Amazon soyfasina gidelim. https://www.amazon.com/
3. Sayfanin konumunu ve boyutlarini yazdirin
4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
8. Sayfayi kapatin
     */

    @Test
    public void test01() {
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(15,15));
        driver.manage().window().setSize(new Dimension(500,600));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

    }
}
