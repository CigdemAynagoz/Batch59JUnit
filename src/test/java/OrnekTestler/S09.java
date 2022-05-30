package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class S09 extends TestBase {
    /*
    1. Bir class oluşturun: LoginTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
a. http://a.testaddressbook.com adresine gidiniz.
b. Sign in butonuna basin
c. email textbox,password textbox, and signin button elementlerini locate ediniz..
d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun
     */

    @Test
    public void test01() throws InterruptedException {
        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("Test1234!");
        WebElement singinButton=driver.findElement(By.xpath("//input[@name='commit']"));
        singinButton.click();

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
      //  password.sendKeys("");
        //ii. Password : Test1234!



        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUserId = "testtechproed@gmail.com";
        Thread.sleep(2000);
        String actuelUserId=driver.findElement(By.xpath("//*[text()='testtechproed@gmail.com']")).getText();
        Assert.assertTrue(expectedUserId.equals(actuelUserId));




        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressessYazisi=driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[1]"));
        Assert.assertTrue(addressessYazisi.isDisplayed());

        WebElement singOut=driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[2]"));
        Assert.assertTrue(singOut.isDisplayed());

        //3. Sayfada kac tane link oldugunu bulun
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("linkList.size() = " + linkList.size());


    }
}
