package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonAcess extends BaseTest {

    @Test
    public void testAcess() {
        // Navigate to Amazon Egypt
        driver.navigate().to("https://www.amazon.eg/");
//        driver.get("https://www.amazon.eg/");

        Actions actions = new Actions(driver);
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-al-your-account")));
        driver.findElement(By.cssSelector("a[href*='order-history']")).click();

        WebElement signInPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authportal-main-section")));
        Assert.assertTrue(signInPrompt.isDisplayed(), "Sign-in prompt is not displayed for 'Your Orders'.");




        driver.navigate().back();
        actions.moveToElement(accountList).perform();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement yourAddresses = driver.findElement(By.xpath("//*[@id='nav_prefetch_youraddresses']"));
        wait.until(ExpectedConditions.elementToBeClickable(yourAddresses)).click();

        // Verify the sign-in prompt is displayed for "Your Addresses"
        signInPrompt = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("authportal-main-section")));
        Assert.assertTrue(signInPrompt.isDisplayed(), "Sign-in prompt is not displayed for 'Your Addresses'.");
        driver.navigate().back();
        actions.moveToElement(accountList).perform();

// Locate the "Your Lists" element and click on it
        WebElement yourLists = driver.findElement(By.cssSelector("span.nav-text"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait2.until(ExpectedConditions.elementToBeClickable(yourLists)).click();


// Alternatively, you can verify by checking for a unique element on the 'Your Lists' page
        WebElement listsIntro = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("your-lists-intro")));
        Assert.assertTrue(listsIntro.isDisplayed(), "'Your Lists' intro screen is not visible.");

    }
}


