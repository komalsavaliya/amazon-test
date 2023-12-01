package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text to the elements
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
//        WebElement emailField = driver.findElement(by);
//        emailField.sendKeys(text);
    }

    /**
     * This method will get the title of the page
     */
    public String getTitle(String text) {
        driver.getTitle();
        return text;
    }

    /**
     * This method will clear the text field
     */
    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }

    /**
     * This method will get text from element
     */
    public void getSizeFromElement(By by) {
        driver.findElement(by).getSize();
    }

    /**
     * This method will verify the expected and actual result
     */
    public void assertEqualsMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }

    public void verifyText(String expected, String actual) {
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
//        WebElement webElement = driver.findElement(by);
//        String text = webElement.getText();
//        return text;
        return driver.findElement(by).getText();
    }


//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept to alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss the alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from the alert
     */
    public String getTextFromAlert(String text) {
        return text;
    }

    /**
     * This method will send text the alert
     */
    public String sendTextToAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
        return key;
    }

    //*************************** Select Class Methods ***************************************//

    /**
     * This method will select the value from dropdown menu
     */

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will select the index from dropdown menu
     */

    public void selectByIndexFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select visible text from dropdown menu
     */
    public void selectByVisibleFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select all the options from dropdown menu
     */
    public void selectByAllOptionsFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allSelectOptions = select.getAllSelectedOptions();
    }

    /**
     * This method will find the list of WebElements
     */
    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will find one WebElement
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method will use to hover mouse on element and click on it.
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void manageElementList(By by, String text) {
        List<WebElement> manageList = driver.findElements(by);
        for (WebElement element : manageList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    //Random Email Method
    protected String email() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();

        while (email.length() < 7) {
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String pre = email.toString() + "@test.com";
        return pre;
    }
    // public static String randomEmail() {
    // return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    // }
}








