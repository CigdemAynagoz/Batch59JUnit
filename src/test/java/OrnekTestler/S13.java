package OrnekTestler;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class S13 extends TestBase {
    /*
    1 ) Bir class oluşturun : Locators_css
2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
b. Locate email textbox
c. Locate password textbox ve
d. Locate signin button
e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
NOT: cssSelector kullanarak elementleri locate ediniz
     */

    @Test
    public void test01() {
        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

        //b. Locate email textbox
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.cssSelector("input[id='session_password']")).sendKeys("Test1234!");

        //c. Locate password textbox ve
        //d. Locate signin button
        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        //NOT: cssSelector kullanarak elementleri locate ediniz
    }
}
