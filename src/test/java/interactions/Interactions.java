package interactions;

import seleniumTests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Interation handles all methods to call WebDriver
 */
public class Interactions {
    public WebDriver driver;

    /**
     * This class handles WebDriver Commands to interact with the Browser
     */
    public Interactions() {
        /** Initialize the right Chrome Driver depending on the OS */
        this.driver = Driver.getChromeDriver();
    }

    /**
     * Navigate to an specific URL
     *
     * @param url Web page to be displayed at the browser
     */
    public void goTo(String url) {
        this.driver.get(url);
    }

    /**
     * Click an specific element
     *
     * @param element element to be clicked
     */
    public void elementClick(WebElement element) {
        element.click();
    }

    /**
     * Enter an specific text into an element
     *
     * @param element element where the text will be entered
     * @param text    text to be entered
     */
    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Submit a form
     *
     * @param element element where the submit action will be triggered
     */
    public void submit(WebElement element) {
        element.submit();
    }

    /**
     * Returns the size for a list
     *
     * @param webElements the list of element where the size will be collected
     * @return Return the list size
     */
    public int getWebElementsListSize(List<WebElement> webElements) {
        return webElements.size();
    }

    /**
     * Get the text for a specific element
     *
     * @param element Element to get the text
     * @return The text inside of the element
     */
    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void waitForElement(String cssSelector){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    public void moveToElementAndClickIt(WebElement element){
        Actions builder = new Actions(driver);
        Action mouseOverAndClick = builder
                .moveToElement(element)
                .click()
                .build();
        mouseOverAndClick.perform();
    }

    /**
     * Close the browser window
     */
    public void quit() {
        this.driver.quit();
    }
}
