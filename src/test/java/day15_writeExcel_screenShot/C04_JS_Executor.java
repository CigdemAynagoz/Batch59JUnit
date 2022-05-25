package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecutorTest() throws InterruptedException {
        //amazona gidelim
        driver.get("https://amazon.com");

        //asagıdaki sing in butonu gorununceye kadar JS ile scrool yapalım
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement singInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",singInButonu);

        //sing in butonuna JS ile click yapalım
        jse.executeScript("arguments[0].click();",singInButonu);
        Thread.sleep(3000);
    }
}
