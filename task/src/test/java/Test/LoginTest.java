package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
//        driver.get("https://www.amazon.eg/");
//        driver.findElement(By.id("nav-link-accountList")).click();
//
//
//        driver.findElement(By.name("email")).sendKeys("asdasda@gaber.com");
//
//        driver.findElement(By.id("continue")).click();
//
//        String errorMessage = driver.findElement(By.cssSelector("#auth-error-message-box .a-list-item")).getText();
//        Assert.assertTrue(errorMessage.contains("We cannot find an account"), "Error message does not match.");
        driver.get("https://www.amazon.eg/");
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.name("email")).sendKeys("asdasda@gaber.com");
        driver.findElement(By.id("continue")).click();


        String errorMessage = driver.findElement(By.cssSelector("#auth-error-message-box .a-list-item")).getText();
        Assert.assertTrue(errorMessage.contains("We can't find an account with this email address."), "Error message does not match.");

        System.out.println(errorMessage);

    }
}