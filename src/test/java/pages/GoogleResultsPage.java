package pages;

import interactions.Interactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Google Results Page
 */
public class GoogleResultsPage {
    private WebDriver driver;
    private Interactions browser;

    // Element Selectors section
    static final String firstResultTitle = ".bkWMgd  .srg h3";
    static final String resultTitles = ".bkWMgd  h2 + .g h3";
    static final String resultDescriptions = ".g .s .st";

    /**
     * List of title on each result item
     * It's needed to use find all to get the all the titles in the google result page
     */
    @FindAll({
            @FindBy(css = firstResultTitle),
            @FindBy(css = resultTitles),
    })
    private List<WebElement> resultItemsTitle;

    /**
     * List of Description on each result item
     */
    @FindBy(css = resultDescriptions)
    private List<WebElement> resultItemsDescription;

    /**
     * Page Objects for Google results page
     *
     * @param browser Browser to interact
     */
    public GoogleResultsPage(Interactions browser) {
        this.browser = browser;
        this.driver = browser.driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Get the specific text in the element at the list by index
     *
     * @param index index in the list for the element
     * @return element text
     */
    public String getResultsTextByIndex(int index) {
        /** Call the browser and get the text */
        return browser.getElementText(resultItemsDescription.get(index));
    }

    /**
     * Get the specific text in the element at the list by index
     *
     * @param index index in the list for the element
     * @return element text
     */
    public String getResultsTitleTextByIndex(int index) {
        /** Call the browser and get the text */
        return browser.getElementText(resultItemsTitle.get(index));
    }

    /**
     * Get the list size
     *
     * @return list size
     */
    public int getTotalResults() {
        /** Call the browser and get the list size */
        return browser.getWebElementsListSize(resultItemsDescription);
    }
}
