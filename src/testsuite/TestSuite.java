package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Create a New Java Project with the Name amazon-test create BaseTest and TestSuite
 * and add all jars.
 * Automate Following Test.
 * 1. Open the url "https://www.amazon.co.uk/"
 * 2. Type "Dell Laptop" in the search box and press enter or click on search
 * Button.
 * 3. Click on the checkbox brand Dell on the left side.
 * 4. Verify that the  30(May be different) products are displayed on the page.
 * 5. Print all product names in the console.
 * 6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
 * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
 * 7. Varify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
 * Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
 * 5. Close the Browser.
 */

public class TestSuite extends Utility {
    static String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() throws InterruptedException {
        // 1. Open the url "https://www.amazon.com"
        openBrowser(baseUrl);
        Thread.sleep(5000);
    }

    @Test
    public void dellLaptop() {
        //Accept the Cookies
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));

        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.name("field-keywords"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));

        //3. Click on the checkbox brand Dell on the left side.
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        //4. Verify that the  30(May be different) products are displayed on the page.
        int expectedQty = 24;
        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty = productList.size();
        Assert.assertEquals("Product QTY does not match", expectedQty, actualQty);


        //5. Print all product names in the console.
        List<WebElement> productNames = findElementsList(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int size = productNames.size();
        System.out.println("Total number of " + size);
        for (WebElement e : productNames) {
            System.out.println(e.getText());
        }

            //Click on second page
            //clickOnElement(By.xpath("//a[@aria-label='Go to page 2']"));

            //6.Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV... Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
            mouseHoverToElementAndClick(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']" +
                    "[contains(text(),'Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscre')]"));

            //7. Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV
            String expectedText = "Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, " + "13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver";
            String actualText = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
            Assert.assertEquals(expectedText, actualText);
        }
    }



