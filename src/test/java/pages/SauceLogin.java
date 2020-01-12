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
public class SauceLogin {

    private WebDriver driver;
    private Interactions browser;

    // Element Selectors section
    static final String userNameLocator =  "input#user-name";
    static final String   passwordLocator = "input#password";
    static final String loginButtonLocator = ".btn_action";


    @FindBy(css = userNameLocator)
    private WebElement username;


    @FindBy(css = passwordLocator )
    private WebElement password;


    @FindBy(css = loginButtonLocator)
    private WebElement loginbutton;


    /**
     * Page Objects for Sauce Page
     *
     * @param browser Browser to interact
     */
    public SauceLogin(Interactions browser) {
        this.browser = browser;
        this.driver = browser.driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to Google page
     */
    public void goToSauceLogin() {
        this.browser.goTo("https://www.saucedemo.com/");
    }


    /**
     * Login
     */
    public void login(String username, String password){

        // Wait for the element
        this.browser.waitForElement(userNameLocator);
        this.username.sendKeys(username);
        this.password.sendKeys(password);

        this.browser.submit(this.loginbutton);
    }
}
