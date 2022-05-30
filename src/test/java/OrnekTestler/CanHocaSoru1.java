package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CanHocaSoru1 extends TestBase {
    @Test
    public void test01() {
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[1]"));
        ilkUrunResmi.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetKontrolu=driver.findElement(By.xpath("//div[@class='cart_item_label']"));
        Assert.assertTrue(sepetKontrolu.isDisplayed());
    }
}
