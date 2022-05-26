package OrnekTestler;

import org.junit.Test;
import utilities.TestBase;

public class S05 extends TestBase {
    /*
    1. Yeni bir Class olusturalim.C06_ManageWindow
2. Amazon soyfasina gidelim. https://www.amazon.com/
3. Sayfanin konumunu ve boyutlarini yazdirin
4. Sayfayi simge durumuna getirin
5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
7. Sayfayi fullscreen yapin
8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
9. Sayfayi kapatin
     */

    @Test
    public void test01() throws InterruptedException {
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());//(-8, -8)

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println(driver.manage().window().getSize());//(1552, 832)

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println(driver.manage().window().getPosition());//(0, 0)
    }
}
