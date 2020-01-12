
package seleniumTests.saucedemo;

import interactions.Interactions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.GooglePage;
import pages.GoogleResultsPage;
import pages.SauceLogin;

/**
 * Created by didier on 8/7/19.
 */
public class SauceDemo {

    @Test
    public void LoginTest() {

        // Initialized the classes to access the browser
        Interactions browser = new Interactions();
        SauceLogin sauceLogin = new SauceLogin(browser);

        sauceLogin.goToSauceLogin();
        sauceLogin.login("standard_user", "secret_sauce");

        Assert.assertEquals("https://www.saucedemo.com/inventory.html", browser.getURLString());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Close the browser
        browser.quit();
    }

}
