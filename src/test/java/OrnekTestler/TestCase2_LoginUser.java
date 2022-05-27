package OrnekTestler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase2_LoginUser extends TestBase {
    @Test
    public void task02() {
        // Test Case 2: Login User with correct email and password
        // 1. Launch browser
        //1. browseri baslatin

        // 2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        //3- Anasayfanın gorunur oldugunu dogrulayin
        String actualAnasayfaUrl = driver.getCurrentUrl();
        String expectedAnasayfaUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedAnasayfaUrl,actualAnasayfaUrl);

        // 4. Click on 'Signup / Login' button
        //4. 'Signup / Login' tuşuna basın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        // 5. 'Login to your account' yazisinin gorunur oldugunu dogrulayin
        WebElement loginYazisi = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(loginYazisi.isDisplayed());

        // 6. Enter correct email address and password
        // 6. Dogru email address and password girin
        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("cgdmgrbz@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456789");

        // 7. Click 'login' button
        // 7. 'login' tusuna basin

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify that 'Logged in as username' is visible
        // 8. 'Logged in as username' yazisinin gorunur oldugunu dogrulayin
        WebElement loggedinYazisi = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedinYazisi.isDisplayed());

        // 9. Click 'Delete Account' button
        // 9. 'Delete Account' tusuna basin
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        // 10. 'ACCOUNT DELETED!' yazisinin gorunu oldugunu dogrulayin
        WebElement deleteYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(deleteYazisi.isDisplayed());

    }



















}
