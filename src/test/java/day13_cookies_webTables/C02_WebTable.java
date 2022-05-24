package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WebTable extends TestBase {
    @Test
    public void test01() {
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
                // Username : manager ○ Password : Manager1!
        girisYap();

        //● table( ) metodu oluşturun
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi: "+sutunBasliklariListesi.size());


        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //● printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi: "+satirlarList.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarList
             ) {
            System.out.println(each.getText());
        }

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each : cellList
             ) {
            System.out.println(each.getText());
        }
        //email baslıgındaki tum elementleri(sutun) konsolda yazdirin
        List<WebElement> baslıklarList=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i <baslıklarList.size() ; i++) {
            if( baslıklarList.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }

        List<WebElement> emailSutunList=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each : emailSutunList
        ) {
            System.out.println(each.getText());
        }


        
    }

    void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
