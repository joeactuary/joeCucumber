package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods2 extends BaseClass {

    /**
     * this method sends text to a given webelement
     *
     * @param element //
     * @param text    //
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * this method will switch to frame by index
     *
     * @param index //
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints a screenshot of the driver
     *
     *
     * @param fileName //
     */

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot takeScreenshot = (TakesScreenshot) BaseClass.driver;
        byte[] picBytes = takeScreenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/" + fileName + "_" + getTimeStamp("YYYY-MM-dd-HH-mm-ss") + ".png"));
         //   FileUtils.copyFile(sourceFile, new File("screenshots/" + fileName + ".png" ));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static void slideHorizontal(WebElement webElement, Integer slideOffset) {
        Actions action = new Actions(BaseClass.driver);
        action.clickAndHold(webElement).moveByOffset(slideOffset, 0).release().build().perform();
    }


    public static void dragAndDrop(WebElement toDrag, WebElement toDropIn) {
        Actions action = new Actions(BaseClass.driver);
        action.dragAndDrop(toDrag, toDropIn).perform();
    }

    public static void doubleClick(WebElement toDoubleClick) {
        Actions action = new Actions(BaseClass.driver);
        action.doubleClick(toDoubleClick).perform();
    }

    public static String acceptAlert() {

        Alert alert = BaseClass.driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;


    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor) driver;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        //pattern YYYY-MM-DD-HH-MM-SS-MS
        //to format the date according to our choice we have a function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


}
