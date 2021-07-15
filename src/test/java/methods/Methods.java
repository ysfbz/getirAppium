package methods;

import base.BaseTest;
import helper.ElementHelper;
import helper.StoreHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import model.ElementInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Methods {

    AndroidDriver driver;
    FluentWait<AndroidDriver> wait;
    Select select;

    public Methods() {
        this.driver = BaseTest.driver;
        wait = new FluentWait<AndroidDriver>(this.driver);
    }

    public By getBy(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        return ElementHelper.getElementInfoToBy(elementInfo);
    }

    public WebElement findElement(String key) {
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
    }

    public List<WebElement> findElements(String key) {
        return driver.findElements(getBy(key));
    }

    public void clickElement(String key) {
        findElement(key).click();
    }

    public void sendKeys(String key, String text) {
        findElement(key).sendKeys(text);
    }


    public WebElement forListElements(String key, String menu) {

        List<WebElement> elements = findElements(key);

        for (WebElement menuItem : elements) {

            if (menuItem.getText().contains(menu)) {
                return menuItem;
            }
        }

        return null;
    }

    public String getListGetText(String key, String name) {
        return forListElements(key, name).getText();
    }

    public WebElement getListElement(String key, String name) {
        return forListElements(key, name);
    }

    public void clickList(String key, String name) {
        getListElement(key, name).click();
    }

    public void sendEnter(String key) {
        findElement(key).sendKeys(Keys.RETURN);
    }

    public void waitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkElementisDisplayed(String key) {
        return findElement(key).isDisplayed();
    }

    public void selectByText(String element, String key) {
        getSelect(element).selectByVisibleText(key);
    }

    public void selectByValue(String element, String key) {
        getSelect(element).selectByValue(key);
    }

    public void selectByIndex(String element, int key) {
        getSelect(element).selectByIndex(key);
    }

    public Select getSelect(String element) {
        return new Select(findElement(element));
    }


    public void goBack() {
        driver.navigate().back();
    }

    public void getElementText(String key, String expectedText) {
        String actualText = findElement(key).getText();
        assertEquals(expectedText,actualText);
    }

}