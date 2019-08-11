package pages;

import interactions.Interactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * Google Page
 */
public class GooglePage {

    private WebDriver driver;
    private Interactions browser;

    // Element Selectors section
    static final String searchField = "q";
    static final String   suggestionListLocator = "[role=\"listbox\"] li .suggestions-inner-container span";

    /**
     * Search input element
     * The locator is using the input name functionality to localize the element
     */
    @FindBy(name = searchField)
    private WebElement searchInput;

    @FindBy(css = suggestionListLocator)
    private List<WebElement> suggestionList;

    /**
     * Page Objects for Google Page
     *
     * @param browser Browser to interact
     */
    public GooglePage(Interactions browser) {
        this.browser = browser;
        this.driver = browser.driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to Google page
     */
    public void goToGoogle() {
        this.browser.goTo("http://www.google.com");
    }

    /**
     * Enter a specific keyword in the search input
     *
     * @param keyword Keyword value
     */
    public void enterkeyword(String keyword) {

        /** Call the browser and enter the text for search */
        this.browser.enterText(this.searchInput, keyword);
    }

    /**
     * Perform the search
     */
    public void search() {

    /** Submit the form */
        this.browser.submit(this.searchInput);
    }

    /**
     * Select an item in the suggestion list and click it
     */
    public void selectRandomItemInSuggestionList(){

        // Wait for the element
        this.browser.waitForElement(suggestionListLocator);

        // Generate a random item to be selected
        Random rd = new Random();
        int randomItem = rd.nextInt(this.browser.getWebElementsListSize(this.suggestionList));

        // Move the mouse to the element and click it
        this.browser.moveToElementAndClickIt(this.suggestionList.get(randomItem));
    }
}
