//package Test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class CartTest extends BaseTest {
//    @Test
//    public void verificationOfCorrectedItems(){
//        driver.get("https://www.amazon.eg/");
//        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/span")).click();
////        driver.findElement(By.linkText("Today’s Deals")).click();
//        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[2]/div/label/span/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[1]/div/a")).click();
//        Select select = new Select(driver.findElement(By.id("quantity")));
//        select.selectByValue("2");
//
//        // Wait until the "Add to Cart" button is clickable
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
//
//        // Scroll to the "Add to Cart" button if necessary
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
////        driver.findElement(By.className("a-button-text")).click();
//        driver.findElement(By.xpath("//a[@data-csa-c-content-id='sw-gtc_CONTENT']")).click();
//
//
////        driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
//
//        // Verify the item name, price, quantity, and subtotal in the cart
//        WebElement cartItemName = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
//        WebElement cartItemPrice = driver.findElement(By.xpath("//span[@class='sc-product-price']"));
//        WebElement cartItemQty = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
//        WebElement cartSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
//
//        // Assertions to verify the correct item is added with the correct details
//        Assert.assertTrue(cartItemName.getText().contains("UHU glue stick"), "Item name does not match.");
//        Assert.assertTrue(cartItemPrice.getText().contains("Expected Price"), "Item price does not match.");
//        Assert.assertEquals(cartItemQty.getText(), "2", "Item quantity does not match.");
//        Assert.assertTrue(cartSubtotal.getText().contains("Expected Subtotal"), "Subtotal does not match.");
//    }
//}


package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {
    @Test
    public void verificationOfCorrectedItems() {
        driver.get("https://www.amazon.eg/");
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[2]/div/label/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[1]/div/a")).click();// Wait until the "Add to Cart" button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

        // Scroll to the "Add to Cart" button if necessary
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);

        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).click();
        Select select = new Select(driver.findElement(By.id("quantity")));
        select.selectByValue("2");

        driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();



        // Verify the item name, price, quantity, and subtotal in the cart
        WebElement cartItemName = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
        WebElement cartItemPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/ul[1]/div[1]/div[1]/div[1]/div[1]/span[1]"));
        WebElement cartItemQty = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        WebElement cartSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));

        // Retrieve actual values from the cart
        String actualItemName = cartItemName.getText();
        String actualItemPrice = cartItemPrice.getText();
        System.out.println(actualItemPrice);
        String actualItemQty = cartItemQty.getText();
        String actualSubtotal = cartSubtotal.getText();
        System.out.println(actualSubtotal);
//        String pricePattern = "\\p{Sc}\\d+(\\.\\d{2})?"; // e.g., $123.45
        String pricePattern = "\\p{Sc}\\d+(\\.\\d{2})?"; // Example: $123.45



//         Assertions
        Assert.assertTrue(actualItemName != null && !actualItemName.isEmpty(), "Item name is not displayed.");
        System.out.println("Item Name: " + actualItemName);

        Assert.assertEquals(actualItemQty, "2", "Item quantity does not match.");
        System.out.println("Item Quantity: " + actualItemQty);



        Assert.assertTrue(actualItemPrice.matches(pricePattern), "Item price format is incorrect.");
        System.out.println("Item Price: " + actualItemPrice);

        Assert.assertTrue(actualSubtotal.matches(pricePattern), "Subtotal format is incorrect.");
        System.out.println("Subtotal: " + actualSubtotal);

//        Assert.assertTrue(actualSubtotal.matches("cartSubtotal"), "Subtotal format is incorrect.");

        // Optionally, you can log the actual values for debugging
//        System.out.println("Item Name: " + actualItemName);
//        System.out.println("Item Price: " + actualItemPrice);
//        System.out.println("Item Quantity: " + actualItemQty);
//        System.out.println("Subtotal: " + actualSubtotal);
    }
}

